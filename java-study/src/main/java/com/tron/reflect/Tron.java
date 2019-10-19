package com.tron.reflect;

public class Tron {
    public String name;
    private Integer age;
    String niceName;

     Tron(String name, Integer age, String niceName) {
        this.name = name;
        this.age = age;
        this.niceName = niceName;
    }

    private void say(String s) {
        System.out.println("say()调用："+s);
    }
}
