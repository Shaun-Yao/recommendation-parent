package com.honji.recommendation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.honji.recommendation.entity.Report;

import java.util.List;


public interface IReportService extends IService<Report> {

    List<Report> listForIndex(String jobNumber, String month);
}
