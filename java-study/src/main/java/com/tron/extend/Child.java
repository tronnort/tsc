package com.tron.extend;

public class Child extends Base {
    public Integer a;
    private Integer s;
    {
        System.out.println("Child代码块执行---- ");
        System.out.println(s+"-----"+a);
    }
}
