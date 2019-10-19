package com.tron.genericity;

public class ScopeGenericityClass<T extends String> {
    T t;

    public void say(T t) {
        System.out.println(t);
    }

    //语法解释，U是一种泛型类型，必须实现comparable接口，且必须可以跟同类型进行比较
    static <U extends Comparable<U>> U compareTo(U u) {
        return u;
    }

    public <V> String talk(V v) {
        return "";
    }
}
