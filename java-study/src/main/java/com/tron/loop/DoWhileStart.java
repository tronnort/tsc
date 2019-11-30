package com.tron.loop;

public class DoWhileStart {
    public static void main(String[] args) {

        int i = 0;  //起始条件  必须
        do {
            System.out.println("循环体"+i);
            ++i; //循环出口操作  必须
        } while (i < 10);
    }
}
