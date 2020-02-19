package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test10");
        tracker.add(item);
        Item[] newItems = tracker.findByName(item.getId());
        assertThat(newItems[0].getName(), is(item.getName()));

    }

    @Test
    public void whenFindAllItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item1 = new Item(null);
        Item item2 = new Item("test2");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] newItems = tracker.findAll();
        Item[] check = new Item[2];
        check[0] = item;
        check[1] = item2;
        assertThat(newItems, is(check));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }
}
