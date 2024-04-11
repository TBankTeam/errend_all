package com.example.common.enums;

public enum RecordsTypeEnum {
    BENEFIT("公益"),
    SERVE("服务"),
    ISSUE("发放"),
    ;

    private String value;

    public String getValue() {
        return value;
    }

    RecordsTypeEnum(String value) {
        this.value = value;
    }
}
