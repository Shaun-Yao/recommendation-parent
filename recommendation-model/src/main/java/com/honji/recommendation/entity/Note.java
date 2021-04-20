package com.honji.recommendation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("recom_note")
public class Note extends BaseEntity {


    /**
     * recommendation Id
     */
    private Long recommendId;

    /**
     * 内容
     */
    private String content;


}
