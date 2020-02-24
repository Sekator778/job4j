package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sekator778@gmail.com", "Alex Nikolaichuk");
        map.put("sekator778@gmail.com", "Alex Nikolaichuk Evgenievich");
        for (String key : map.keySet()
             ) {
            String value = map.get(key);
            System.out.println(key + " - " + value);
        }
    }
}
