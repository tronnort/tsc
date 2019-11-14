package com.tron.designpattern.strategy;

/**
 * @Description
 * @auther tron
 * @create 2019-11-14
 */
class Car {
    private CarEngine engine;

    Car() {
        engine = ()->"Default Engine Start";
    }

    void setCarEngine(CarEngine carEngine) {
        this.engine = carEngine;
    }

    void run() {
        System.out.println("========>"+engine.start());
    }
}
