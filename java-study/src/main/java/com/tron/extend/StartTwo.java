package com.tron.extend;

public class StartTwo {
    public static void main(String[] args) {
        Child child = new Child();
        Base base = child;

        System.out.println("=================================================");

        Base baseOther = new Base();

        System.out.println("child----action");
        child.action();

        System.out.println("base----action");
        //向上转型时方法动态调用
        base.action();

        System.out.println("base1----action");
        baseOther.action();

        System.out.println("----");
        System.out.println("child.s: "+child.a);
        System.out.println("base.s: "+base.a);
    }
}
