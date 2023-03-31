package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class A {
    private Integer a;

    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    public Date date;
}
