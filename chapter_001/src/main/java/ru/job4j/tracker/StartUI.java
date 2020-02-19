package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: \n");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item.getName());
                }
            } else if (select == 2) {
                String nameNew = input.askStr("=== Edit item (replace) === \n === Enter name newItem === \n");
                String idOld = input.askStr("=== Enter id item for replace ===");
                if (tracker.replace(idOld, new Item(nameNew))) {
                    System.out.println("=== Item replaced ===");
                } else {
                    System.out.println("=== Error ===");
                }
            } else if (select == 3) {
                System.out.println();
                String id = input.askStr("=== Delete item === \n === Enter id Item for delete === \n");
                if (tracker.delete(id)) {
                    System.out.println("=== delete successful ===");
                } else {
                    System.out.println("=== delete error ===");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                String id = input.askStr("=== Enter id Item ===");
                System.out.println(tracker.findById(id).getName());
            } else if (select == 5) {
                String name = input.askStr("=== Find items by name ===\n === Enter name Item === \n");
                Item[] items = (tracker.findByName(name));
                for (Item item : items) {
                    System.out.println(item.getId());
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}