package ru.job4j.tracker;

public class EndAction implements UserAction {
    @Override
    public String name() {
        return "=== END. ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Program close");
        return false;
    }
}
