package com.honji.recommendation.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.honji.recommendation.entity.Note;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.model.DataGridResult;
import com.honji.recommendation.service.INoteService;
import com.honji.recommendation.service.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/index")
    public String index() {
        return "recommendations";
    }

    @ResponseBody
    @GetMapping("/list")
    public DataGridResult list(@RequestParam(defaultValue = "0") int offset, @RequestParam int limit,
             @RequestParam(required = false) String mobile) {
        IPage<Recommendation> recommendationPage = new Page<>(offset / limit + 1, limit);
        QueryWrapper<Recommendation> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(mobile)) {
            queryWrapper.like("mobile", mobile);
        }

        return new DataGridResult(recommendationService.page(recommendationPage, queryWrapper));
    }

}
