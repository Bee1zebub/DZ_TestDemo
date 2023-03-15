package com.example.result;

import com.alibaba.fastjson.JSONObject;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;

public class ResultVo {
    public static void main(String[] args) {
//        if(StringUtils.isNotBlank("ff")){
//            String cmy = String.format("This is %s", "cmy");
//            System.out.println(cmy);
//        }
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects);
        if (objects != null) {
            String s = JSONObject.toJSONString(objects);
            System.out.println(s);
        }
    }
}
