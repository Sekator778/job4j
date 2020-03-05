package ru.job4j.tracker;

import java.util.function.Consumer;

public class EndAction implements UserAction {
    @Override
    public String name() {
        return "=== END. ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("Program close");
//        System.out.println("Program close");
        return false;
    }
}
