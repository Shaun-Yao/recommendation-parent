package com.honji.recommendation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.honji.recommendation.entity.Recommendation;
import com.honji.recommendation.model.RecommendationVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2021-04-03
 */
public interface RecommendationMapper extends BaseMapper<Recommendation> {

    @Select({"<script>",
            "SELECT user.phone_number, rec.phone_number as customer_phone_number, rec.* FROM recommendation rec ",
            "LEFT JOIN user on rec.user_id = user.id ",
            "<if test='phoneNumber!=null and phoneNumber!=\"\"'>",
            "where rec.phone_number like CONCAT('%', #{phoneNumber}, '%')",
            "</if>",
            "</script>"})
    IPage<RecommendationVO> selectForIndex(IPage<Recommendation> page, @Param("phoneNumber") String phoneNumber);
}
