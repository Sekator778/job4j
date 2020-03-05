package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("=== Enter id Item ===");
        Item item = tracker.findById(id);
        if (item == null) {
            output.accept(" wrong id ");
        } else {
            output.accept("name: " + item.getName() + " id:" + item.getId());
        }
        return true;
    }
}
