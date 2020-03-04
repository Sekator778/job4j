package ru.job4j.collection.comparator;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    /**
     * метод, который вытаскивает из строки число до точки
     * и возвращает это число
     */
    static Integer extractNumber(String s) {
        return Integer.valueOf(s.split(". ")[0]);
    }

    /**
     * метод полученную строку кидает в метод extractNumber
     * тот дает цифру и мы ее компареТо
     *
     * @param left  - строка 1
     * @param right - строка 2
     * @return - результат сравнения кто больше меньше
     */
    @Override
    public int compare(String left, String right) {
        return extractNumber(left).compareTo(extractNumber(right));
    }
}