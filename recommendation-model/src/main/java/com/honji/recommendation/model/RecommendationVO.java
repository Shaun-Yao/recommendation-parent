package com.honji.recommendation.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.honji.recommendation.entity.BaseEntity;
import com.honji.recommendation.enums.ModeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
public class RecommendationVO {

    private Long id;

    /**
     * 推荐人手机号
     */
    private String phoneNumber;

    /**
     * 被推荐客户姓名
     */
    private String name;

    /**
     * 被推荐客户手机号
     */
    private String customerPhoneNumber;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String district;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdTime;

}
