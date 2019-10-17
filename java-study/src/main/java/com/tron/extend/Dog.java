package com.tron.extend;

public class Dog extends Animal {

    //覆盖了父类的final属性
    public String finalData;

    @Override
    public String toString() {
        return "Dog重写超级父类的toString方法";
    }
}
