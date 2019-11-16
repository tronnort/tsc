package com.tron.designpattern.observer;

public class Start {
    public static void main(String[] args) {
        TronSubject tronSubject = new TronSubject();
        TronObserver tronObserver = new TronObserver(tronSubject);

        tronSubject.notifyObserver("发布消息");
    }
}
