package com.example.testRmssp;

class Test{
    Inter1 inter1;

    public Test(Inter1 inter1){
        this.inter1 = inter1;
    }

    public void show(){
        inter1.show();
    }
}

public class Demo1 {
    public static Test show1(String str) {
        Test test = new Test(new Inter1() {
            @Override
            public void show() {
                System.out.println(str);
            }
        });
        return test;
    }

    public static void main(String[] args) {
        Test ss = show1("ss");
        ss.show();
    }
}
