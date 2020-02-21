package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item (replace) ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idOld = input.askStr("=== Enter id item for replace ===");
        String nameNew = input.askStr(" === Enter name newItem === ");
        if (tracker.replace(idOld, new Item(nameNew))) {
            System.out.println("=== Item replaced ===");
        } else {
            System.out.println("=== Error ===");
        }
        return true;
    }
}
