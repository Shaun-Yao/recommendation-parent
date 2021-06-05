package com.honji.recommendation.entity;

import com.honji.recommendation.enums.ModeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * <p>
 * 
 * </p>
 *
 * @author yao
 * @since 2021-04-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Recommendation extends BaseEntity {

    public Recommendation(Long userId, String name, String phoneNumber, String province,
                          String city, String district, ModeEnum mode, Integer space, String comment) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.province = province;
        this.city = city;
        this.district = district;
        this.mode = mode;
        this.space = space;
        this.comment = comment;
    }

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


}
