package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("=== Enter id Item for delete ===" + System.lineSeparator());
        if (tracker.delete(id)) {
            output.accept("=== delete successful ===");
        } else {
            output.accept("=== delete error ===");
        }
        return true;
    }
}
