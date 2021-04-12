package com.honji.recommendation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.mapper.RecommendationMapper;
import com.honji.recommendation.model.RecommendationVO;
import com.honji.recommendation.service.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2021-04-03
 */
@Service
public class RecommendationServiceImpl extends ServiceImpl<RecommendationMapper, Recommendation> implements IRecommendationService {

    @Autowired
    private RecommendationMapper recommendationMapper;

    @Override
    public IPage<RecommendationVO> listForIndex(int offset, int limit, String phoneNumber) {
        IPage<Recommendation> page = new Page<>(offset / limit + 1, limit);
        return recommendationMapper.selectForIndex(page, phoneNumber);
    }
}
