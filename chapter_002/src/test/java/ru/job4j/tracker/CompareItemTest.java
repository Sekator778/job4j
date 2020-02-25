package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class CompareItemTest {
    @Test
    public void compareUp() {
        List<Item> list = Arrays.asList(
                new Item("Jan"),
                new Item("Karl"),
                new Item("Olga"),
                new Item("Anna")
        );
        List<String> expectList = Arrays.asList(
                "Anna", "Jan", "Karl", "Olga"
        );
        List<String> nameUp = new ArrayList<>();
        Collections.sort(list, new ItemUp());
        for (Item item : list
        ) {
            nameUp.add(item.getName());
        }
        assertThat(nameUp, is(expectList));
    }

    @Test
    public void compareDown() {
        List<Item> list = Arrays.asList(
                new Item("Jan"),
                new Item("Karl"),
                new Item("Olga"),
                new Item("Anna")
        );
        List<String> expectList = Arrays.asList(
                "Olga", "Karl", "Jan", "Anna"
        );
        List<String> nameUp = new ArrayList<>();
        list.sort(new ItemDown());
        for (Item item : list
        ) {
            nameUp.add(item.getName());
        }
        assertThat(nameUp, is(expectList));
    }

    @Test
    public void compareDown2() {
        List<Item> list = Arrays.asList(
                new Item("Jan"),
                new Item("Karl"),
                new Item("Olga"),
                new Item("Anna")
        );
        List<Item> expectList = Arrays.asList(
                new Item("Olga"),
                new Item("Karl"),
                new Item("Jan"),
                new Item("Anna")
        );
        list.sort(new ItemDown());
        assertThat(list, is(expectList));
    }
}
