package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.IsNull.nullValue;
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
        Item[] newItems = tracker.findByName(item.getName());
        assertThat(newItems[0].getName(), is(item.getName()));

    }

//    @Test
//    public void whenFindAllItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("test1");
//        Item item1 = new Item(null);
//        Item item2 = new Item("test2");
//        tracker.add(item);
//        tracker.add(item1);
//        tracker.add(item2);
//        Item[] newItems = tracker.findAll();
//        Item[] check = new Item[2];
//        check[0] = item;
//        check[1] = item2;
//        assertThat(newItems, is(check));
//    }

    @Test
    public void whenFindAllItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item);
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

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    /**
     * тест метод показывет полиморфизм а именно
     * мы имеем 2 реализации интерфейса Input
     * при вызове StartUI.createItem(input...
     * мы подменяем ConsoleInput на StubInput
     */
    @Test
    public void whenStartUICreateItem() {
        String[] answer = {"fix method"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item ourIn = tracker.findAll()[0];
        Item expect = new Item("fix method");
        assertThat(ourIn.getName(), is(expect.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("old item");
        tracker.add(item);
        String[] answers = {item.getId(), "new item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("new item"));
    }
}
