package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("=== Enter name Item === " + System.lineSeparator());
        Item[] items = (tracker.findByName(name));
        for (Item item : items) {
            System.out.println("name: " + item.getName() + " id:" + item.getId());
        }
        return true;
    }
}
