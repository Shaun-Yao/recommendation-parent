package com.honji.recommendation.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.honji.recommendation.entity.Note;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.entity.User;
import com.honji.recommendation.service.INoteService;
import com.honji.recommendation.service.IRecommendationService;
import com.honji.recommendation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yao
 * @since 2021-04-03
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession session;

    @ResponseBody
    @PostMapping("/save-phone-number")
    public boolean savePhoneNumber(@RequestParam String phoneNumber) {
        User user = (User) session.getAttribute("user");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", user.getId())
                .set("phone_number", phoneNumber);
        boolean result = userService.update(updateWrapper);
        if (result) { //更新代码后需要更新session
            user.setPhoneNumber(phoneNumber);
            session.setAttribute("user", user);
        }
        return result;
    }

}
