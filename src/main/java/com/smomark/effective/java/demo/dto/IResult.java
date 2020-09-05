package com.smomark.effective.java.demo.dto;

import lombok.NonNull;

@SuppressWarnings("unchecked")
public interface IResult<T> {

    Boolean isSuccess();

    void success();

    void success(T data);

    void fail();

    void fail(T data);

    static void registerResultClass(@NonNull Class<? extends IResult> resultClass) {
        ResultClassHolder.defaultResultClass = resultClass;
    }

    static <T> IResult<T> buildSuccessResult() {
        IResult<T> result = ResultClassHolder.newInstance();
        result.success();
        return result;
    }

    static <T> IResult<T> buildSuccessResult(T data) {
        IResult<T> result = ResultClassHolder.newInstance();
        result.success(data);
        return result;
    }

    static <T> IResult<T> buildFailResult() {
        IResult<T> result = ResultClassHolder.newInstance();
        result.fail();
        return result;
    }

    static <T> IResult<T> buildFailResult(T data) {
        IResult<T> result = ResultClassHolder.newInstance();
        result.fail(data);
        return result;
    }

    class ResultClassHolder {
        private static Class<? extends IResult> defaultResultClass = Result.class;

        private static <T> IResult<T> newInstance() {
            try {
                return defaultResultClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("Cannot Instance Result");
            }
        }
    }
}


