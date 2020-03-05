package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            System.out.println("name: " + item.getName() + " id:" + item.getId());
        }
        return true;
    }
}
