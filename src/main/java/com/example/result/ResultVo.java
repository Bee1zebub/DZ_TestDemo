package com.example.result;

import com.example.enums.ExceptionMsg;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultVo<T> {

    private Integer code = 200;
    private List<String> message = new ArrayList<>();
    private T data;

    public ResultVo(){
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(ExceptionMsg.SUCCESS.getMessage());
        this.setMessage(msgList);
    }

    public ResultVo(T data) {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(ExceptionMsg.SUCCESS.getMessage());
        this.setMessage(msgList);
        setData(data);
    }

    public ResultVo(ExceptionMsg message , T data) {
        this.setCode(message.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(message.getMessage());
        this.setMessage(msgList);
        setData(data);
    }

}
