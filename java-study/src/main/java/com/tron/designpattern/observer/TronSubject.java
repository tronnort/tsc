package com.tron.designpattern.observer;

import java.util.ArrayList;

public class TronSubject implements Subject {

    private ArrayList<Observer> observers;

    public TronSubject() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String s) {
        observers.stream().forEach(e->e.update(s));
    }
}
