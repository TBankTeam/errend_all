package com.example.common.enums;

public enum OrderStatusEnum {

    CANCEL("已取消"),
    NO_ACCEPT("待接单"),
    NO_ACHIEVE("已接单"),
    NO_EXAMINE("待审核"),
    NO_VERIFY("待确认"),
    DONE("已完成"),
    ;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
