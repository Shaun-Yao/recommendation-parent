package com.honji.recommendation.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ReportUser extends BaseEntity {


    /**
     * 工号
     */
    private String jobNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 职位
     */
    private String position;

    /**
     * 区域
     */
    private String area;


}
