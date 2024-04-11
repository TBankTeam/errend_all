package com.example.common.enums;

public enum AdminAddressEnum {
    ADMIN_ADDRESS_ENUM("0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49");

    private String value;

    public String getValue() {
        return value;
    }

    AdminAddressEnum(String value) {
        this.value = value;
    }
}
