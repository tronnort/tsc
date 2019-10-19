package com.tron.extend;

public class Child extends Base {
    public static Integer a;
    private Integer s;
    static{
        System.out.println("Child静态代码块执行---- Child.a: " + a  );
        a = 10;
    }
    {
        System.out.println("Child代码块执行---- Child.a: " + s);
        s = 10;
    }
    Child(){
        System.out.println("Child构造方法执行----");
        System.out.println("Child.a :" + a);
        System.out.println("Child.s :" + s);
        System.out.println("Child构造方法执行结束----");
    }

    protected void step() {
        System.out.println("a: "+ a +", s: "+s);
    }

}
