package com.tron.thread;

public class Start {
    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.start();
//        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(new SimpleRunnable());
        thread.setName("tron simpleRunnable start-----");
        thread.setPriority(10);  //1-10  默认为5   数值越大越先启动
        thread.start();
    }
}
