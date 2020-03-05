package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String name = input.askStr("=== Enter name Item === " + System.lineSeparator());
        List<Item> items = tracker.findByName(name);
        for (Item item : items) {
            System.out.println("name: " + item.getName() + " id:" + item.getId());
        }
        return true;
    }
}
