package com.smomark.effective.java.demo.common.enums;

/**
 * 使用枚举类型强化Singleton属性
 */
public enum Elvis {
    INSTANCE;

    public void method() {
        System.out.println("Singleton By Enum");
    }
}
