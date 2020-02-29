package test.arrays;

import java.util.*;

public class RemoveArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println("size after init " + list.size());
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        System.out.println("size after100 add " + list.size());
        list.removeIf(n -> (n > 600));
        System.out.println("size after delete 400 el " + list.size());

        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add(null);
        stringHashSet.add(null);
        Set<String> stringHashSet2 = new TreeSet<>();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i) + "val");
        }
        for (Map.Entry<Integer, String> pair : map.entrySet()
             ) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        map.entrySet().forEach(System.out::println);
        System.out.println("set key - > map");
        for (Integer key : map.keySet()
             ) {
            System.out.println(key);
        }
        System.out.println("=======value==========");
        for (String value : map.values()
             ) {
            System.out.println(value);
        }
        System.out.println(map.get(2));
        System.out.println(" value stream  ");
        map.values().forEach(System.out::println);




    }
}
