package com.honji.recommendation.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.model.RecommendationVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yao
 * @since 2021-04-03
 */
public interface IRecommendationService extends IService<Recommendation> {

    IPage<RecommendationVO> listForIndex(int offset, int limit, String phoneNumber);
}
