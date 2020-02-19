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

    /**
     * Метод возвращает новый масив.
     * Который состоит из старого за исключением null ячеек
     *
     * @return цельный масив
     */
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

    /**
     * @param name имя итема итему
     * @return возвращаем масив елементов у которых одинаковое имя
     */
    public Item[] findByName(String name) {
        Item[] newItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(name)) {
                newItems[size] = items[i];
                size++;
            }
        }
        newItems = Arrays.copyOf(newItems, size);
        return newItems;
    }

    /**
     * @param id уникальный ключ у кажого итема
     * @return получаем итем
     */
    public Item findById(String id) {
        Item item = new Item(null);
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                item = items[i];
            }
        }
        return item;
    }

    /**
     * @param id уникальный ключ у кажого итема
     * @return возвращает индекс елемента в масиве итемов items
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
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
        if (!(indexOf(id) >= 0)) {
            return false;
        }
        int index = indexOf(id);
        item.setId(id);
        items[index] = item;
        return true;
    }

    public boolean delete(String id) {
        if (!(indexOf(id) >= 0)) {
            return false;
        }
        int index = indexOf(id);
        System.arraycopy(items, index + 1, items, index, (position - index));
        items[position] = null;
        position--;
        return true;
    }
}