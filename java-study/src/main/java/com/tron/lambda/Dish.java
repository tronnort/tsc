package com.tron.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

//菜品
@Data
@AllArgsConstructor
public class Dish {
    private  String name;
    private  boolean vegetarian;
    private  int calories;
    private  Type type;

    public enum Type { MEAT, FISH, OTHER }
}
