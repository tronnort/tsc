package com.tron.collection;

import java.util.HashSet;

public class TronHasSet {
    public static void main(String[] args) {
        HashSet<DataForSet> hashSet = new HashSet<>();
        hashSet.add(new DataForSet("same", 1));
        hashSet.add(new DataForSet("same", 1));  //可以排除重复的对象，没有import lombok.Data的时候需要重写hashCode() equals(Object o)方法
        for (DataForSet dataForSet : hashSet) {
            System.out.println(dataForSet);
        }
    }
}
