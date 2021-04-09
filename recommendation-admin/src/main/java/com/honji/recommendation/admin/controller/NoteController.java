package com.honji.recommendation.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.honji.recommendation.entity.Note;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.model.DataGridResult;
import com.honji.recommendation.service.INoteService;
import com.honji.recommendation.service.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @ResponseBody
    @GetMapping("/list")
    public List<Note> list(@RequestParam Long recommendId) {
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("recommend_id", recommendId);

        return noteService.list(queryWrapper);
    }

    @PostMapping("/save")
    @ResponseBody
    public boolean save(@ModelAttribute Note note) {

        return noteService.save(note);
    }
}
