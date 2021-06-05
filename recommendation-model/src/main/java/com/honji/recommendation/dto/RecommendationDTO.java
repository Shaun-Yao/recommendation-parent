package com.honji.recommendation.dto;

import com.honji.recommendation.enums.ModeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDTO {


    /**
     * userId
     */
    private Long userId;

    /**
     * 被推荐客户姓名
     */
    private String name;

    /**
     * 被推荐客户手机号
     */
    private String phoneNumber;

    /**
     * 省份
     */
    private String[] region;

    /**
     * 合作模式
     */
    private ModeEnum mode;

    /**
     * 面积
     */
    private Integer space;

    /**
     * 备注
     */
    private String comment;
}
