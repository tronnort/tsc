package com.tron.control;

public class IfControl {
    public static void main(String[] args) {

        //if判断
        if (true) {
            System.out.println("条件为真时进入该语句。条件可以是运算，或者返回值为Boolean的方法");
        }

        //if else 判断
        if (false) {

        }else {
            System.out.println("if判断为false时进入该语句。条件可以是运算，或者返回值为Boolean的方法");
        }

        //简单的if else 可以用三元运算替代
       String reslut = false ? "a" : "b";
    }
}
