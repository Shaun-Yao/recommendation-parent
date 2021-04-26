package com.honji.recommendation.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum PositionEnum {

    MANAGER("manager", "大区经理"),
    SUPERVISOR("supervisor", "督导")
    ;
    PositionEnum(String code, String desc) {
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
