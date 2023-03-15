package com.example.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class ScreenPageEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    public static void main(String[] args) {
        ScreenPageEntity entity = new ScreenPageEntity();
        entity.setId(4124124L);
        String string = JSON.toJSONString(entity);
        System.out.println(string);
    }
}