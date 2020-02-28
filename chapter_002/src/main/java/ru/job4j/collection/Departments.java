package ru.job4j.collection;

import java.util.*;

public class Departments {
    /**
     * Добавляем недостающие департаменты.
     *
     * @param deps Множество департаментов.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            StringJoiner sb = new StringJoiner("/");
            for (String el : value.split("/")) {
                sb.add(el);
                tmp.add(sb.toString());
            }
        }
        return new ArrayList<>(tmp);
    }
}