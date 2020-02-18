package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        Item[] newItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName() != null) {
                newItems[size] = items[i];
                size++;
            }
        }
        newItems = Arrays.copyOf(newItems, size);
        return newItems;
    }

    public Item[] findByName(String key) {
        Item[] newItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(key)) {
                newItems[size] = items[i];
                size++;
            }
        }
        newItems = Arrays.copyOf(newItems, size);
        return newItems;
    }

    public Item findById(String id) {
        Item item = new Item(null);
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                item = items[i];
            }
        }
        return item;
    }
}