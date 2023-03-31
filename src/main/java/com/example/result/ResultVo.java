package com.example.result;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultVo<T> {

    private Integer code = 200;
    private List<String> message = new ArrayList<>();
    private T data;

    public ResultVo(){

    }


}
