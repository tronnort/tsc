package com.tron.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class DishStart {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        Map<Dish.Type, List<Dish>> collect = test03(menu);
        List<String> threeHighCaloricDishNames1 = test02(menu);
        long count = test01(menu);

        System.out.println(collect);
    }

    private static Map<Dish.Type, List<Dish>> test03(List<Dish> menu) {
        return menu.stream().collect(Collectors.groupingBy(Dish::getType));
    }


    private static List<String> test02(List<Dish> menu) {
        return menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3).collect(toList());
    }

    private static long test01(List<Dish> menu) {
        return menu.stream().filter(d -> d.getCalories() > 300).distinct().limit(10).count();
    }
}
