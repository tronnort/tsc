package com.tron.extend;

public class Base {
    public static Integer a;
    private Integer s;

    static {
        System.out.println("Base静态代码块执行---- base.a："+a);
        a = 1;
    }
    {
        System.out.println("Base代码块执行---- base.a："+s);
        s = 1;
    }

    Base() {
        System.out.println("Base构造方法执行----");
        System.out.println("Base.a ："+a);
        System.out.println("Base.s : "+s);
        System.out.println("Base构造方法执行结束----");
    }

    protected void step() {
        System.out.println("a: "+ a +", s: "+s);
    }

    protected void action() {
        System.out.println("start");
        step();
        System.out.println("end");
    }
}
