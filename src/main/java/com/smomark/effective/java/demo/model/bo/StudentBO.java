package com.smomark.effective.java.demo.model.bo;

import lombok.Getter;
import lombok.ToString;

/**
 * 建造者模式处理多参数构造实体类
 */
@Getter
@ToString
public class StudentBO {
    /**
     * Required
     */
    private final String name;
    private final Integer age;

    /**
     * Optional
     */
    private final String email;
    private final String qq;

    private StudentBO(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.qq = builder.qq;
    }

    public static class StudentBuilder {
        private String name;
        private Integer age;
        private String email;
        private String qq;

        public StudentBuilder(String name, Integer age){
            this.name = name;
            this.age = age;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder qq(String qq) {
            this.qq = qq;
            return this;
        }

        public StudentBO build() {
            return new StudentBO(this);
        }
    }
}
