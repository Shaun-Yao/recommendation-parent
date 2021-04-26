package com.honji.report.controller;

import com.honji.recommendation.entity.ReportUser;
import com.honji.recommendation.model.DataGridResult;
import com.honji.recommendation.service.IReportUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/report-user")
public class ReportUserController {

    @Autowired
    private IReportUserService reportUserService;

    @GetMapping("/index")
    public String index() {
        return "report-users";
    }

    @ResponseBody
    @GetMapping("/get")
    public ReportUser get(@RequestParam Long id) {

        return reportUserService.getById(id);
    }

    @ResponseBody
    @GetMapping("/list")
    public DataGridResult list(@RequestParam(defaultValue = "0") int offset, @RequestParam int limit,
                                           @RequestParam String name) {

        return new DataGridResult(reportUserService.listForIndex(offset, limit, name));
    }

    @PostMapping("/save")
    @ResponseBody
    public boolean save(@ModelAttribute ReportUser reportUser) {

        return reportUserService.saveOrUpdate(reportUser);
    }

    @ResponseBody
    @PostMapping("/remove")
    public boolean remove(@RequestParam List<Long> ids) {
        return reportUserService.removeByIds(ids);
    }
}
