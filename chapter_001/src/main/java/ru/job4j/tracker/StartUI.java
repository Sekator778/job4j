package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select:" + System.lineSeparator());
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItem(input, tracker);
            } else if (select == 2) {
                StartUI.replace(input, tracker);
            } else if (select == 3) {
                StartUI.delete(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItem(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

    public static void replace(Input input, Tracker tracker) {
        String nameNew = input.askStr("=== Edit item (replace) ===" + System.lineSeparator() + " === Enter name newItem === ");
        String idOld = input.askStr("=== Enter id item for replace ===");
        if (tracker.replace(idOld, new Item(nameNew))) {
            System.out.println("=== Item replaced ===");
        } else {
            System.out.println("=== Error ===");
        }
    }

    public static void delete(Input input, Tracker tracker) {
        System.out.println();
        String id = input.askStr("=== Delete item ===" + System.lineSeparator() + "=== Enter id Item for delete ===" + System.lineSeparator());
        if (tracker.delete(id)) {
            System.out.println("=== delete successful ===");
        } else {
            System.out.println("=== delete error ===");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        String id = input.askStr("=== Enter id Item ===");
        if (tracker.findById(id) == null) {
            System.out.println(" wrong id ");
        } else {
            System.out.println("name: " + tracker.findById(id).getName() + " id:" + tracker.findById(id).getId());
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String name = input.askStr("=== Find items by name ===" + System.lineSeparator() + "=== Enter name Item === " + System.lineSeparator());
        Item[] items = (tracker.findByName(name));
        for (Item item : items) {
            System.out.println(item.getId());
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