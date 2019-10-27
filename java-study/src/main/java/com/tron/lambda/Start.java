package com.tron.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple().setWeight(1));
        apples.add(new Apple().setWeight(2));
        apples.add(new Apple().setWeight(10));
        apples.add(new Apple().setWeight(3));
        //未排序前
        System.out.println(apples);
        //升序排序后
        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        apples.sort(byWeight);
        System.out.println(apples);
        //降序排序后
//        apples.sort((a, b) -> -a.getWeight().compareTo(b.getWeight()));
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(apples);


    }

    static List get(List<Integer> list) {
        try {
            list.sort(Integer::compareTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    static void test() {

    }
}
