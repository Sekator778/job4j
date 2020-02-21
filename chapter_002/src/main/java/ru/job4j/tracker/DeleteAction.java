package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("=== Enter id Item for delete ===" + System.lineSeparator());
        if (tracker.delete(id)) {
            System.out.println("=== delete successful ===");
        } else {
            System.out.println("=== delete error ===");
        }
        return true;
    }
}
