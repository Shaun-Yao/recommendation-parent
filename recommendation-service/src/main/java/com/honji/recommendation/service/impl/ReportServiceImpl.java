package com.honji.recommendation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honji.recommendation.entity.Report;
import com.honji.recommendation.mapper.ReportMapper;
import com.honji.recommendation.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements IReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Report> listForIndex(String jobNumber, String month) {


        return reportMapper.selectForIndex(jobNumber, month);
    }
}
