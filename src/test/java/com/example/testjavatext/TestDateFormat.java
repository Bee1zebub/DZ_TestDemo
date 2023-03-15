package com.example.testjavatext;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestDateFormat {

    @Test
    public void test01(){
        SimpleDateFormat df = new SimpleDateFormat();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        df.applyPattern("yyyy-MM-dd HH:mm:ss");
        String s = df.format(ts);
        System.out.println(s);
    }
}
