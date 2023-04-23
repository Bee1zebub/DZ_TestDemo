package com.example.result;

import com.example.enums.ExceptionMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回信息封装
 * Copyright © 2019 Xinke(Shanghai) Network Science and Technology Co., Ltd. All rights reserved.
 *
 * @author yy
 * @date 2019/4/03
 */
public class ResultVo<T> {

    /**
     * 错误码
     */

    private Integer code = 200;
    /**
     * 提示信息
     */

    private List<String> message = new ArrayList<>();
    /**
     * 具体内容
     */

    private T data;

    public ResultVo() {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(ExceptionMsg.SUCCESS.getMsg());
        this.setMessage(msgList);
    }

    ResultVo(int i) {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(ExceptionMsg.SUCCESS.getMsg());
        this.setMessage(msgList);
    }

    public ResultVo(T data) {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(ExceptionMsg.SUCCESS.getMsg());
        this.setMessage(msgList);
        this.setData(data);
    }

    ResultVo(ExceptionMsg message, String rspMsg, T data) {
        this.setCode(message.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(rspMsg);
        this.setMessage(msgList);
        this.setData(data);
    }

    ResultVo(int code, String rspMsg, T data) {
        this.setCode(code);
        List<String> msgList = new ArrayList<>();
        msgList.add(rspMsg);
        this.setMessage(msgList);
        this.setData(data);
    }

    ResultVo(ExceptionMsg message, List<String> rspMsg, T data) {
        this.setCode(message.getCode());
        this.setMessage(rspMsg);
        this.setData(data);
    }

    ResultVo(ExceptionMsg message, T data) {
        this.setCode(message.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(message.getMsg());
        this.setMessage(msgList);
        this.setData(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}
