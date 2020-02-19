package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item (replace) ===");
                System.out.println("=== Enter name newItem ===");
                String nameNew = scanner.nextLine();
                System.out.println("=== Enter id item for replace ===");
                String idOld = scanner.nextLine();
                if (tracker.replace(idOld, new Item(nameNew))) {
                    System.out.println("=== Item replaced ===");
                } else {
                    System.out.println("=== Error ===");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("=== Enter id Item for delete ===");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("=== delete successful ===");
                } else {
                    System.out.println("=== delete error ===");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.println("=== Enter id Item ===");
                String id = scanner.nextLine();
                System.out.println(tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.println("=== Enter name Item ===");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}