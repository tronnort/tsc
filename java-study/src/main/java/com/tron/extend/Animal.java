package com.tron.extend;

public class Animal {
    String name;

    public Integer age;

    private boolean exist;

    final String finalData = "finalData";

    static String staticData = "staticData";

    void eat() {
        System.out.println("Animal eating");
    }

    void sleep() {
        System.out.println("Animal sleeping");
    }
}
