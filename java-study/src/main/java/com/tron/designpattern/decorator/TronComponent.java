package com.tron.designpattern.decorator;

public class TronComponent implements Component {
    @Override
    public void say() {
        System.out.println("TronComponent say");
    }
}
