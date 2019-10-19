package com.tron.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Start {
    public static void main(String[] args) throws Exception{

        //获取Class类的方法
        Class<Tron> tronClass = Tron.class;
        //获取Class类的方法
        Tron tron = new Tron("tron",18,"zhenwuhuan");
        Class<? extends Tron> tronClassOne = tron.getClass();
        //获取Class类的方法
        try {
            Class<?> aClass = Class.forName("com.tron.reflect.Tron");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }

        //得到Class类以后 拿类名称信息
        System.out.println(tronClass.getName()); //com.tron.reflect.Tron
        System.out.println(tronClass.getSimpleName()); //Tron
        System.out.println(tronClass.getCanonicalName()); //com.tron.reflect.Tron
        System.out.println(tronClass.getPackage()); //package com.tron.reflect

        //得到Class类以后 拿类的属性信息

        Field[] publicFields = tronClass.getFields();
        System.out.println(publicFields.length);  //1

        Field[] allFields = tronClass.getDeclaredFields();
        System.out.println(allFields.length); //3

        //可以读出对象的属性的名称和值以及注解信息

        for (Field field : allFields) {
            field.setAccessible(true);
            System.out.println(field.getName()+":"+field.get(tron));
            /*name:tron
            age:18
            niceName:zhenwuhuan*/

            //获取注解
//            field.getAnnotation();
//            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        }

        //得到Class类以后 获得方法信息
        Method[] methods = tronClass.getMethods(); //包含父类的信息
        System.out.println(methods.length); //9

        //调用有参的方法public方法
//        Method say = tronClass.getMethod("say",String.class);
//        say.invoke(tron,"hello");

        //调用非public方法要
        Method[] declaredMethods = tronClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if ("say".equals(method.getName())) {
                method.setAccessible(true);
                method.invoke(tron, "hello");
            }
        }

        //创建一个对象
//        Tron tronOne = tronClassOne.newInstance(); //只能掉无参构造，如果没有就抛异常InstantiationException

        Constructor<?>[] publicConstructors = tronClassOne.getConstructors();//必须是public
        System.out.println(publicConstructors.length); //0

        Constructor<?>[] declaredConstructors = tronClassOne.getDeclaredConstructors();
        System.out.println(declaredConstructors.length);//1

        Object o = declaredConstructors[0].newInstance("tron", 18, "tronnort");
        Tron decTron = (Tron) o;
        System.out.println(decTron.niceName); //tronnort


        //其他方法
        Class<? super Tron> superclass = tronClass.getSuperclass(); //获得父类
        int modifiers = tronClass.getModifiers();  //修饰符
        Class<?>[] interfaces = tronClass.getInterfaces(); //接口
        Annotation[] annotations = tronClass.getAnnotations(); //所有注解包括继承得到的
        Annotation[] declaredAnnotations = tronClass.getDeclaredAnnotations(); //自己声明的注解



    }
}
