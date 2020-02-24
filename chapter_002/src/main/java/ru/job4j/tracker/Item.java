package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item {
    private String id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<Item> list = Arrays.asList(
                new Item("Jan"),
                new Item("Karl"),
                new Item("Olga"),
                new Item("Anna")
        );
        list.forEach(n -> System.out.println(n.getName()));
        Collections.sort(list, new ItemUp());
        list.forEach(n -> System.out.println(n.getName()));

    }


}