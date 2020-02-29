package test;

import java.util.*;

public class IteratoRemove {
    public static void main(String[] args) {
        Set<String> list = new HashSet<>();
        list.add("Bob1");
        list.add("Bob2");
        list.add("Bob3");
        list.add("Bob4");
        list.forEach(System.out::println);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("Bob3")) {
                iterator.remove();
            }
        }
        System.out.println("after remove");
        list.forEach(System.out::println);

    }
}
