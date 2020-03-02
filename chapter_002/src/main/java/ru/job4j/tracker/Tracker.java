package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public void add(Item item) {
        item.setId(this.generateId());
        items.add(item);
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

    /**
     * Метод возвращает новый масив.
     * Который состоит из старого за исключением null ячеек
     *
     * @return цельный масив
     */
    public  List<Item> findAll() {
        return items;
    }

    /**
     * @param name имя итема итему
     * @return возвращаем масив елементов у которых одинаковое имя
     */
    public List<Item> findByName(String name) {
        List<Item> newItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                newItems.add(item);
            }
        }
        return newItems;
    }

    /**
     * @param id уникальный ключ у кажого итема
     * @return получаем итем
     */
    public Item findById(String id) {
        int index = indexOf(id);
        if (index != -1) {
            return items.get(index);
        }
        return null;
    }

    /**
     * @param id уникальный ключ у кажого итема
     * @return возвращает индекс елемента в масиве итемов items
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    /**
     * @param id   старый айди
     * @param item новый итем с новым айди
     * @return пока не ясно что тестить
     */
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items.set(index, item);
        return true;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }
}