package ru.job4j.tracker;

import java.util.function.Consumer;

public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item (replace) ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String idOld = input.askStr("=== Enter id item for replace ===");
        String nameNew = input.askStr(" === Enter name newItem === ");
        if (tracker.replace(idOld, new Item(nameNew))) {
            output.accept("=== Item replaced ===");
        } else {
            output.accept("=== Error ===");
        }
        return true;
    }
}
