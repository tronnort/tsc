package com.tron.loop;

public class WhileStart {
    public static void main(String[] args) {

        int i = 0; //起始条件   必须
        while ( i < 10) {
            System.out.println("循环体"+i);
//            ++i;
            i++;   //循环出口操作   必须
        }
    }
}
