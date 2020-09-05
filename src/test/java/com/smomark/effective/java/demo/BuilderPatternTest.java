package com.smomark.effective.java.demo;

import com.smomark.effective.java.demo.model.bo.StudentBO;

public class BuilderPatternTest {
    public static void main(String[] args) {
        StudentBO studentBO = new StudentBO.StudentBuilder("smomark", 23)
                .email("myemail@163.com").build();
        System.out.println(studentBO);
    }
}
