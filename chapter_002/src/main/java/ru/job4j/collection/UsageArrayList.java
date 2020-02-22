package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Sasha");
        list.add("Masha");
        list.add("Dasha");
        for (String s : list
        ) {
            System.out.println(s);
        }
    }
}
