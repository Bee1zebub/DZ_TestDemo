package com.example.result;

import com.example.enums.ExceptionMsg;

public class Result {
    public static <T> ResultVo<T> success(T object){
        ResultVo<T> vo = new ResultVo<T>(ExceptionMsg.SUCCESS,object);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }
}
