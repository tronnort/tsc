package com.tron.extend;

public class StartOne {
    public static void main(String[] args) {
        Bird bird = new Bird("画眉鸟",1);
        System.out.println(bird.age);
        System.out.println(bird.name);
        //不能继承父类的private属性
        bird.eat();   //没有被override的方法执行父类的方法
        bird.sleep(); //被重写方法调用类本身的方法
        //------------------------------------
        Animal animal = new Animal();
        animal = bird;
        System.out.println(animal.age);
        System.out.println(animal.name);
        animal.eat();
        animal.sleep();
        //---------------------------
        Animal otherAnimal = new Bird("比列鸟", 2);
        System.out.println(otherAnimal.age);
        System.out.println(otherAnimal.name);
        otherAnimal.eat();
        otherAnimal.sleep();
        System.out.println(Bird.staticData);   //类属性用类名访问
        //---------------------------
        System.out.println(new Dog());
        System.out.println(new Dog().finalData); //可以被继承---可能被覆盖--但是不能被修改
        //--------------------

    }
}
