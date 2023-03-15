package com.example.fastjson;

import com.alibaba.fastjson.JSON;
import com.example.entity.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class TestJSONObject {

    @DisplayName(value = "测试Date")
    @Test
    public void testDateFormatter(){
        A a = new A();
        a.setA(11);
        Date date = new Date();
    }

    public static void main(String[] args) {
        // 反序列化
        String jsonstring = "{\"a\": 12}";
        A a = JSON.parseObject(jsonstring, A.class);
        System.out.println(a);

        //序列化
        String s = JSON.toJSONString(a);
        System.out.println(s);

        String jsonStringArray = "[{\"a\": 11},{\"a\": 12},{\"a\": 13},{\"a\": 14}]";

        List<A> list = JSON.parseArray(jsonStringArray, A.class);
        System.out.println(list.size());

    }
}
