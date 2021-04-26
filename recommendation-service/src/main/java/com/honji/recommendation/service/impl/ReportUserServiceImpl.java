package com.honji.recommendation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honji.recommendation.entity.ReportUser;
import com.honji.recommendation.mapper.ReportUserMapper;
import com.honji.recommendation.service.IReportUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class ReportUserServiceImpl extends ServiceImpl<ReportUserMapper, ReportUser> implements IReportUserService {

    @Autowired
    private ReportUserMapper reportUserMapper;

    @Override
    public IPage<ReportUser> listForIndex(int offset, int limit, String name) {

        IPage<ReportUser> page = new Page<>(offset / limit + 1, limit);
        QueryWrapper<ReportUser> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        return reportUserMapper.selectPage(page, queryWrapper);
    }
}
