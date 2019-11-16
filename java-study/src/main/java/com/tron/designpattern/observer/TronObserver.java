package com.tron.designpattern.observer;

public class TronObserver implements Observer {
    private String str;

    private Subject subject;

    public TronObserver(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }
    @Override
    public void update(String s) {
        str = s;
        print();
    }

    public void print() {
        System.out.println("接受发布到的消息："+str);
    }
}
