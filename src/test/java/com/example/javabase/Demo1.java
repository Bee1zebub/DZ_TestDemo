package com.example.javabase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

public class Demo1 {

    @Test
    public void test1(){
        //append方法往StringBuilder中添加数据
        //append方法返回的是this即调用方法的对象bu1
        //创建对象
        StringBuilder bu1 = new StringBuilder();
        //使用append对象无需接受返回值，返回值就是本身
        //append可以添加任何数类型
        bu1.append("abc");
        bu1.append(1);
        bu1.append(true);
        bu1.append(8.8);
        bu1.append('中');
        System.out.println(bu1);        //abc1true8.8中
    }

    public static void main(String[] args) {
        String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
        //第一种方式
        Map maps = (Map) JSON.parse(str);
        System.out.println("这个是用JSON类来解析JSON字符串!!!");
        for (Object map : maps.entrySet()){
            System.out.println(((Map.Entry)map).getKey()+"     " + ((Map.Entry)map).getValue());
        }
        //第二种方式
        Map mapTypes = JSON.parseObject(str);
        System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
        for (Object obj : mapTypes.keySet()){
            System.out.println("key为："+obj+"值为："+mapTypes.get(obj));
        }
        //第三种方式
        Map mapType = JSON.parseObject(str,Map.class);
        System.out.println("这个是用JSON类,指定解析类型，来解析JSON字符串!!!");
        for (Object obj : mapType.keySet()){
            System.out.println("key为："+obj+"值为："+mapType.get(obj));
        }
        //第四种方式
        /**
         * JSONObject是Map接口的一个实现类
         */
        Map json = (Map) JSONObject.parse(str);
        System.out.println("这个是用JSONObject类的parse方法来解析JSON字符串!!!");
        for (Object map : json.entrySet()){
            System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
        }
        //第五种方式
        /**
         * JSONObject是Map接口的一个实现类
         */
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println("这个是用JSONObject的parseObject方法来解析JSON字符串!!!");
        for (Object map : json.entrySet()){
            System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
        }
        //第六种方式
        /**
         * JSONObject是Map接口的一个实现类
         */
        Map mapObj = JSONObject.parseObject(str,Map.class);
        System.out.println("fasdfsaf"+mapObj.toString());
        System.out.println("这个是用JSONObject的parseObject方法并执行返回类型来解析JSON字符串!!!");
        for (Object map: json.entrySet()){
            System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
        }
        String strArr = "{{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"11\":\"lisi\",\"22\":\"wangwu\",\"33\":\"maliu\"}}";
        // JSONArray.parse()
        System.out.println(json);
    }
}
