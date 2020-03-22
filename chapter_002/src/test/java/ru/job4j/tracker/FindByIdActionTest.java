package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByIdActionTest {

    @Test
    public void whenFindById() {
        PrintStream std = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{item1.getId()});
        new FindItemByIdAction().execute(input, tracker, System.out::println);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("name: " + item1.getName() + " id:" + item1.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(std);
    }

    @Test
    public void whenFindByIdAndAnyItemNameIsNull() {
        PrintStream std = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item1 = new Item(null);
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{item2.getId()});
        new FindItemByIdAction().execute(input, tracker, System.out::println);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("name: " + item2.getName() + " id:" + item2.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(std);
    }
}