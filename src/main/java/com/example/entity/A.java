package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class A {
    private Integer a;

    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    public Date date;
}
