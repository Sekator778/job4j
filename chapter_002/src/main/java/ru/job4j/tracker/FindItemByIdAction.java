package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("=== Enter id Item ===");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println(" wrong id ");
        } else {
            System.out.println("name: " + item.getName() + " id:" + item.getId());
        }
        return true;
    }
}
