package com.honji.recommendation.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum ModeEnum {

    JIA_MENG("jia-meng", "加盟"),
    LIAN_YING("lian-ying", "联营")
    ;
    ModeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue
    private final String code;
    private final String desc;


//    @Override
//    public String toString() {
//        return this.code;
//    }
}
