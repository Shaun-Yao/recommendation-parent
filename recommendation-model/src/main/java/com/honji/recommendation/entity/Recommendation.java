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
     * 意向区域
     */
    private String area;

    /**
     * 合作模式
     */
    private ModeEnum mode;

    /**
     * 面积
     */
    private Integer space;



}
