package ru.job4j.tracker;

import java.util.function.Consumer;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}