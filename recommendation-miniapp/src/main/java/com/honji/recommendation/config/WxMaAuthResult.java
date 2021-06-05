package com.honji.recommendation.config;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.honji.recommendation.entity.User;
import lombok.Data;

@Data
public class WxMaAuthResult extends WxMaJscode2SessionResult {
    private String code;

    private String token;

    private int expiresIn = -1;

    Boolean isReg = false; //是否保存过用户信息

    private boolean success;

    private User user;
}
