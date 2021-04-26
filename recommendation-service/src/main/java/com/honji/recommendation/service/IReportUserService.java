package com.honji.recommendation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.honji.recommendation.entity.ReportUser;


public interface IReportUserService extends IService<ReportUser> {

    IPage<ReportUser> listForIndex(int offset, int limit, String name);
}
