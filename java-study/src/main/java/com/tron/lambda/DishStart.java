package com.tron.lambda;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
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

        //分组
        Map<Dish.Type, List<Dish>> collect = test03(menu);
        //截取
        List<String> threeHighCaloricDishNames1 = test02(menu);
        //统计
        long count = test01(menu);

        //找到最大值
        Optional<Dish> optional = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));

        //找到最小值
        Optional<Dish> optional1 = menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));

        //连接字符串
        String names = menu.stream().map(Dish::getName).collect(joining(" - "));
        System.out.println(names);

        //统计
        Integer sum = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        Integer sum1 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(sum);
        System.out.println(sum1);

        //对第一个分组的结果在进行分组
        Map<Dish.Type, Map<String, List<Dish>>> typeMapMap = menu.stream().collect(Collectors.groupingBy(Dish::getType, groupingBy(d -> {
            if ( d.getCalories() > 300) {
                return "1";
            }
            return "2";
        })));
        System.out.println(typeMapMap);


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
