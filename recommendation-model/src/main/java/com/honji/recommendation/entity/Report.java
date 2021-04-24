package com.honji.recommendation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Report extends BaseEntity {


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
    @DateTimeFormat(pattern = "yyyy-MM-dd EEE")
    @JsonFormat(pattern="yyyy-MM-dd EEE",timezone="GMT+8")
    private LocalDate date;


}
