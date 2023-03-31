package com.example.testMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

public class Demo1 {
    @Test
    public void test01(){
        Boolean b = true ;
        if(b){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    @Test
    public void test02() {
        int a = 0;
        for(int i = 0 ;i<=5 ; i++){
            if(i == 2){
                System.out.println(3);
                break;
            }
            a = i;
            System.out.println("qq");
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        String str1 = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
        Map<String,Object> mapObj = JSON.parseObject(str1,Map.class);
        Map<String,Object> mapObj2 = JSON.parseObject(str1);
        System.out.println(mapObj.toString());
        System.out.println(mapObj);
        for(Map.Entry<String, Object> entry : mapObj.entrySet() ){
            System.out.println(entry.getKey().getClass());
            System.out.println(entry.getValue().getClass());
        }
        System.out.println(mapObj2.toString());
        System.out.println(mapObj2);
        for(Map.Entry<String, Object> entry : mapObj2.entrySet() ){
            System.out.println(entry.getKey().getClass());
            System.out.println(entry.getValue().getClass());
        }

        /*JSONObject jsonObject = JSON.parseObject(mapObj.toString());
        System.out.println(jsonObject.getString("0"));*/
        JSONObject jsonObject2 = JSON.parseObject(mapObj2.toString());
        System.out.println(jsonObject2.getString("0"));
    }
}
