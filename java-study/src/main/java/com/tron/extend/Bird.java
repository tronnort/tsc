package com.tron.extend;

public class Bird extends Animal {
    Bird(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    void sleep() {
        System.out.println("画眉sleeping");
    }
}
