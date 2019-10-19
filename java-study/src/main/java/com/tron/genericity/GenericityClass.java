package com.tron.genericity;

//处理数据的类型不是决定的，而是传入的参数类型
//public class GenericityClass<A,B>{}
public class GenericityClass<T> {
    T first;
    T second;

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
