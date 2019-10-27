package com.tron.lambda;

import java.util.ArrayList;
import java.util.HashMap;

public class MapStart {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.forEach((k,v)->{keys.add(k);values.add(v);});
        System.out.println(keys);
        System.out.println(values);
    }
}
