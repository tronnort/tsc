package com.tron.designpattern.strategy;

/**
 * @Description
 * @auther tron
 * @create 2019-11-14
 */
public class Start {
    public static void main(String[] args) {
        Car car = new Car();
        car.run();
        car.setCarEngine(()->"BMW Engine Start");
        car.run();
    }
}
