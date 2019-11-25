package com.tron.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-25
 */
public class TronHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");

        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }

        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<String,String> entry : entrySet) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }

        hashMap.forEach((k,v)->{
            System.out.println(k+"----"+v);
        });


    }
}
