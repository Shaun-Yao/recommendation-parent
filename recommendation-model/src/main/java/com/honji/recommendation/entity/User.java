package com.honji.recommendation.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("recom_user")
public class User extends BaseEntity {

    public User(String openId, String nickName){
        this.openId = openId;
        this.nickName = nickName;
    }

    /**
     * 微信openid
     */
    private String openId;

    /**
     * 微信昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phoneNumber;

//    @TableField(exist = false)
//    private List<Participant> participants = new ArrayList<>();

}
