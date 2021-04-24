package com.honji.report.controller;

import com.honji.recommendation.entity.Report;
import com.honji.recommendation.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @GetMapping("/index")
    public String index(@RequestParam String jobNumber, Model model) {
        String month = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        model.addAttribute("jobNumber", jobNumber);
        model.addAttribute("month", month);
        return "reports";
    }

    @ResponseBody
    @GetMapping("/get")
    public Report get(@RequestParam Long id) {

        return reportService.getById(id);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Report> list(@RequestParam String jobNumber, @RequestParam String month) {

        return reportService.listForIndex(jobNumber, month);
    }

    @PostMapping("/save")
    @ResponseBody
    public boolean save(@ModelAttribute Report report) {

        return reportService.saveOrUpdate(report);
    }

    @ResponseBody
    @PostMapping("/remove")
    public boolean remove(@RequestParam Long id) {
        return reportService.removeById(id);
    }
}
