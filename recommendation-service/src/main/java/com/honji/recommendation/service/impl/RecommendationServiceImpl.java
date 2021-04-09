package com.honji.recommendation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.mapper.RecommendationMapper;
import com.honji.recommendation.service.IRecommendationService;
import org.springframework.stereotype.Service;

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

}
