package com.example.result;


import com.example.enums.ExceptionMsg;

import java.util.List;

/**
 * 返回信息封装
 * Copyright © 2019 Xinke(Shanghai) Network Science and Technology Co., Ltd. All rights reserved.
 *
 * @author yy
 * @date 2019/4/03
 */
public class Result {
    public static <T> ResultVo<T> success(T object, List<String> msg) {
        ResultVo vo = new ResultVo<>(ExceptionMsg.SUCCESS, msg, object);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }

    public static <T> ResultVo<T> success(T object) {
        ResultVo vo = new ResultVo<>(object);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }

    public static <T> ResultVo<T> success() {
        ResultVo vo = new ResultVo<>(1);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }

    public static <T> ResultVo<T> error(ExceptionMsg code, List<String> msg) {
        ResultVo vo = new ResultVo<>(code, msg, null);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }

    public static <T> ResultVo<T> error(ExceptionMsg code, String msg) {
        ResultVo vo = new ResultVo<>(code, msg, null);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }

    public static <T> ResultVo<T> error(int code, String msg) {
        ResultVo vo = new ResultVo<>(code, msg, null);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }

    public static <T> ResultVo<T> error(ExceptionMsg code) {
        ResultVo vo = new ResultVo<>(code, null);
//        LoggerUtil.info("返回结果 ->>>>>>", JSON.toJSONString(vo));
        return vo;
    }
}
