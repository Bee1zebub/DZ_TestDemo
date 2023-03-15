package com.example.controller;

import com.example.entity.ScreenPageEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "product/test",produces = "application/json;charset=utf-8")
public class ScreenController {

    @GetMapping(value = "test1")
    public ScreenPageEntity test1(){
        ScreenPageEntity entity = new ScreenPageEntity();
        entity.setId(4124124L);
        return entity;
    }
}
