package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        if (tasks.size() != 0) {
            for (Task element : tasks) {
                if (task.getPriority() < element.getPriority()) {
                    break;
                } else {
                    index++;
                }
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.remove(0);
    }
}