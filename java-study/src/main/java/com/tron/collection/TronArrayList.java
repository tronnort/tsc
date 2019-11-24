package com.tron.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/***
 *
 * arrayList内部采用动态数组实现。
 * 1、可以随机访问，按照索引位置进行访问效率很高
 * 2、除非数组已排序，否则按照内容查找元素效率低
 * 3、添加元素效率一般
 * 4、插入和删除元素效率低
 *
 */
public class TronArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("添加元素到末尾");
        arrayList.isEmpty(); //判断是否为空
        arrayList.size();  //获取长度
        arrayList.get(0); //访问指定位置的元素
        arrayList.indexOf("查找元素，返回索引位置，未找到返回-1");
        arrayList.lastIndexOf("从后往前找");
        arrayList.contains("根据equals方法判断是否包含元素");
        arrayList.remove(0); //删除指定位置元素
        arrayList.remove("删除指定对象");
        arrayList.clear();  //删除所有元素
        arrayList.add(0, "指定位置添加元素");
        arrayList.set(0, "修改指定位置元素");

        // Iterable<E>接口实现
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        //Collection<E>接口实现
        arrayList.add("只保留参数容器中的值");
        arrayList.retainAll(Arrays.asList("只保留参数容器中的值")); //如果有的话，及取两个容器的共有部分
        for (String s : arrayList) {
            System.out.println(s);
        }

        //arrayList转数组
        Object[] objects = arrayList.toArray();
        String[] strings = arrayList.toArray(new String[arrayList.size()]);

        //数组转arrayList
        List<String> stringList = Arrays.asList("1", "2", "3");
//        stringList.add("4");  转换出来的list是Arrays的内部类，不能当普通的list使用。这里会抛异常

        String[] strs = {"1", "2", "3"};
        List<String> asList = Arrays.asList(strs);

        List<String> initList = Arrays.asList(new String[]{"1", "2", "3"});
    }
}

