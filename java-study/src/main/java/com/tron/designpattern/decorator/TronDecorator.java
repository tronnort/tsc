package com.tron.designpattern.decorator;

public class TronDecorator implements Component {

    private Component component;

    public TronDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void say() {
        component.say();
        System.out.println("TronDecorator say");
    }
}
