package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DeleteActionTest {

    @Test
    public void whenDeleteItem() {
        String newMessage = "New Item";
        Tracker tracker = new Tracker();
        Item item = new Item(newMessage);
        tracker.add(item);
        String[] answers = {item.getId()};
        new DeleteAction().execute(new StubInput(answers), tracker, System.out::println);
        Item deleted = tracker.findById(item.getId());
        Item expected = null;
        assertThat(deleted, is(expected));
    }

}