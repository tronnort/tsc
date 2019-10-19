package com.tron.genericity;

public class GenericityMethod {
    public <T> T getData(T t ) {
        return t;
    }

    public static class Tron<U,V>{
        U first;
        V second;

        public Tron(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static <U, V> Tron<U, V> createTron(U first,V second) {
        Tron<U, V> uvTron = new Tron<>(first, second);
        return uvTron;
    }
}
