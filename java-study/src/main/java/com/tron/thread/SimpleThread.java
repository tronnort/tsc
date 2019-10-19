package com.tron.thread;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程名称"+Thread.currentThread().getName()+" 线程Id："+Thread.currentThread().getId());
        System.out.println("SimpleThread-----------run");
    }
}
