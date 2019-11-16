package com.tron.designpattern.decorator;

public class Start {
    public static void main(String[] args) {
        Component component = new TronComponent();
        component = new TronDecorator(component);
        component = new TronDecorator(component);
        component.say();
    }
}
