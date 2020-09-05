package com.smomark.effective.java.demo;

import com.smomark.effective.java.demo.dto.IResult;

public class IResultTest {

    public static void main(String[] args) {
        IResult<String> iResult = IResult.buildSuccessResult();
        System.out.println(iResult.isSuccess());
        System.out.println(iResult);
    }
}
