package com.smomark.effective.java.demo.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
class Result<T> implements IResult<T> {
    private String errCode;
    private String errMsg;
    private T data;

    private static final String SUCCESS_CODE = "SUCCESS";
    private static final String SUCCESS_MSG = "成功";
    private static final String FAIL_CODE = "FAIL";
    private static final String FAIL_MSG = "失败";

    @Override
    public Boolean isSuccess() {
        return Objects.equals(this.errCode, SUCCESS_CODE);
    }

    @Override
    public void success() {
        this.errCode = SUCCESS_CODE;
        this.errMsg = SUCCESS_MSG;
    }

    @Override
    public void success(T data) {
        this.success();
        this.data = data;
    }

    @Override
    public void fail() {
        this.errCode = FAIL_CODE;
        this.errMsg = FAIL_MSG;
    }

    @Override
    public void fail(T data) {
        this.fail();
        this.data = data;
    }
}
