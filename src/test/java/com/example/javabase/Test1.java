package com.example.javabase;

import com.example.entity.A;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

public class Test1 {

    @Test
    public void test1(){
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(list2);
        list1.add(3);
        //System.out.println(list1);
        //System.out.println(list2);
        // 一个简单的for循环
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++)
        {
            Integer flag = list1.get(i);
            if(list2.contains(flag) == false){
                System.out.println(flag);
            }
//            for (int j = 0; j < list2.size(); j++) {
//                if (flag == list2.get(j)) {
//                    // 执行该语句时将结束循环
//                    break;
//                }else{
//                    list3.add(flag);
//                }
//            }
        }
        //System.out.println(list3);
    }

    @Test
    public void test2(){
        String s = String.valueOf(new Integer(12));
        System.out.println(s.getClass());
    }

    @Test
    public void test3(){
        ArrayList<Integer> objects = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(objects));
    }
    public static void main(String[] args) {
        // 一个简单的for循环

        for (int i = 0; i < 10; i++)
        {
            System.out.println("i的值是" + i);
            for (int j = 0; j <=5; j++) {
                System.out.println("j的值是" + j);
                if (j == 2) {
                    // 执行该语句时将结束循环
                    break;
                }
            }
        }
        // 修改位置
         // 修改位置2
    }
}
