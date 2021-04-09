package com.honji.recommendation.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.honji.recommendation.entity.User;
import com.honji.recommendation.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws IOException {

        //微信业务域名验证直接通过
        if("/MP_verify_9dQkDF12uPmh1y78.txt".equals(request.getRequestURI())) {
            return true;
        }

        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return true;
        }

        //session过期需要重新使用微信网页登录授权
        if (StringUtils.isEmpty(code)) {
            String url = request.getRequestURL().toString();
//            String busId = request.getParameter("busId");
//            String prefix = request.getParameter("prefix");
//            if (StringUtils.isNotEmpty(busId)) {
//                url = url.concat("?busId=").concat(busId);
//            }
//            if (StringUtils.isNotEmpty(prefix)) {
//                url = url.concat("?prefix=").concat(prefix);
//            }

            String authUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
            response.sendRedirect(authUrl);
        } else { //回调带有code参数需要校验
            try {
                WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
                WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
                final String openId = wxMpUser.getOpenId();
                final String nickName = wxMpUser.getNickname();
                //log.info(openId);
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("open_id", openId);
                User persistedUser = userService.getOne(queryWrapper);
//                session.setAttribute("openId", openId);
//                User user = userService.getForSession(openId);
                if(persistedUser == null) {
                    User newUser = new User(openId, nickName);
                    userService.save(newUser);
                    session.setAttribute("user", newUser);
                } else {
                    session.setAttribute("user", persistedUser);
                }
                return true;
            } catch (WxErrorException e) {
                log.error("微信网页授权异常", e);
            }
        }

        return false;
    }

}
