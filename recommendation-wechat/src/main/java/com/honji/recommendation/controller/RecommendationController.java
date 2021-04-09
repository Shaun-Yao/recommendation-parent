package com.honji.recommendation.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.honji.recommendation.entity.Note;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.entity.User;
import com.honji.recommendation.model.DataGridResult;
import com.honji.recommendation.service.INoteService;
import com.honji.recommendation.service.IRecommendationService;
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
@RequestMapping("/recommendation")
public class RecommendationController {

    @Autowired
    private IRecommendationService recommendationService;

    @Autowired
    private INoteService noteService;

    @Autowired
    private HttpSession session;

    @GetMapping("/index")
    public String index() {
        return "recommendations";
    }

    @GetMapping("/toAdd")
    public String toAdd() {
        return "recommendation-form";
    }

    @GetMapping("/toEdit")
    public String toEdit(@RequestParam Long id, Model model) {
        Recommendation recommendation = recommendationService.getById(id);
        model.addAttribute("recommendation", recommendation);
        return "recommendation-form";
    }

    @GetMapping("/progress")
    public String progress(@RequestParam Long id, Model model) {
        Recommendation recommendation = recommendationService.getById(id);
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("recommend_id", recommendation.getId());
        List<Note> notes = noteService.list(queryWrapper);
        model.addAttribute("recommendation", recommendation);
        model.addAttribute("notes", notes);
        return "recommendation-progress";
    }


    /**
     * 微信端推荐列表
     * @param model
     * @return
     */
    @GetMapping("/list-all")
    public String listAll(Model model) {
        User user = (User) session.getAttribute("user");
        QueryWrapper<Recommendation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        List<Recommendation> recommendations = recommendationService.list(queryWrapper);
        model.addAttribute("recommendations", recommendations);
        return "recommendation-list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Recommendation recommendation) {
        User user = (User) session.getAttribute("user");
        recommendation.setUserId(user.getId());
        recommendationService.saveOrUpdate(recommendation);
        return "redirect:/recommendation/list-all";
    }

    /**
     * 判断手机号是否已经存在
     * @param mobile
     * @return
     */
    @ResponseBody
    @GetMapping("/is-mobile-exist")
    public boolean isMobileExist(@RequestParam String mobile) {
        QueryWrapper<Recommendation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        Recommendation recommendation = recommendationService.getOne(queryWrapper);
        if (recommendation != null) {//手机号已经存在
            return true;
        }

        return false;
    }
}
