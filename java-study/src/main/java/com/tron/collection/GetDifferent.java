package com.tron.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-24
 */
public class GetDifferent {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1", "2", "3");
        List<String> list2 = Arrays.asList("1", "2","3","4");
        //根据值判断是否相等
        boolean equals = list1.equals(list2);

        //找出差异>>遍历大列表，判断不在小列表中的值取出来
        List<String> different = getDifferent(list2, list1);
        System.out.println(different);


        //数据库查出的列表小于传参则执行新增，否则执行删除
        //判断是执行新增还是删除
        boolean b = list1.size() - list2.size() > 0;

        if (list1.size() - list2.size() > 0) {
            // todo 新增方法
        }else {
            //todo  删除方法
        }

    }

    private static List<String> getDifferent(List<String> list1, List<String> list2) {
        if (list2.size() - list1.size() > 0) {
            return list2.stream().filter(i -> !list1.contains(i)).collect(Collectors.toList());
        }else {
            return list1.stream().filter(i -> !list2.contains(i)).collect(Collectors.toList());
        }
    }
}
