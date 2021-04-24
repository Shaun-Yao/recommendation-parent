package com.honji.recommendation.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class ReportVO {

    private  Long id;

    /**
     * 工号
     */
    private String jobNumber;

    /**
     * 计划内容
     */
    private String content;

    /**
     * 对计划内容的批注
     */
    private String comment;

    /**
     * 计划日期
     */
    private LocalDate date;
}
