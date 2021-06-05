package com.honji.recommendation.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.honji.recommendation.config.WxMaAuthResult;
import com.honji.recommendation.config.WxMaConfiguration;
import com.honji.recommendation.entity.User;
import com.honji.recommendation.service.IUserService;
import com.honji.recommendation.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/wx/user/{appid}")
public class WxMaUserController {

    @Autowired
    private IUserService userService;

    /**
     * 登陆接口
     */
    @GetMapping("/login")
    public String login(@PathVariable String appid, String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }

        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            //TODO 可以增加自己的逻辑，关联业务相关数据
//            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//            queryWrapper.eq("open_id", session.getOpenid());
//            User user = userService.getOne(queryWrapper);
//            if (user == null) {
//
//            }
            return JsonUtils.toJson(session);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return e.toString();
        }
    }


    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @GetMapping("/info")
    public String info(@PathVariable String appid, String code,
                       String signature, String rawData, String encryptedData, String iv) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }


        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        WxMaJscode2SessionResult session = null;
        try {
            session = wxService.getUserService().getSessionInfo(code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            //TODO 可以增加自己的逻辑，关联业务相关数据


        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
        }

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(session.getSessionKey(), rawData, signature)) {
            return "user check failed";
        }

        WxMaAuthResult wxMaAuthResult = new WxMaAuthResult();
        // 解密用户信息
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), encryptedData, iv);

        String openId = session.getOpenid();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        User persistedUser = userService.getOne(queryWrapper);
        if (persistedUser == null) {
            User user = new User(openId, userInfo.getNickName());
            userService.save(user);
            //TODO 加入redis缓存
//            wxMaAuthSessionStorage.addWxMaSession(expire,third_session,wxMaUserInfoExtends);
            userInfo.setOpenId("");
            wxMaAuthResult.setSuccess(true);
            wxMaAuthResult.setIsReg(false);
            wxMaAuthResult.setUser(user);
        } else {
            //存在 数据库更新
//            wxMaUserMapper.addWxMaUser(wxMaUserInfoExtends);
            //这里是将用户信息存到redis
//            wxMaAuthSessionStorage.addWxMaSession(expire,third_session,wxMaUserInfoExtends);
            //不把openId传到前台
            userInfo.setOpenId("");
            wxMaAuthResult.setIsReg(true);
            wxMaAuthResult.setSuccess(true);
            wxMaAuthResult.setUser(persistedUser);
        }

        return JsonUtils.toJson(wxMaAuthResult);
    }


}
