package ru.job4j.collection;

import java.util.*;

public class Departments {
    /**
     * Добавляем недостающие департаменты.
     *
     * @param deps Множество департаментов.
     */
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new LinkedHashSet<>();
        ArrayList<String> rsl = new ArrayList<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(el + "/");
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : tmp
        ) {
            sb.append(s);
            rsl.add(sb.toString().substring(0, sb.length() - 1));
        }
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("K1/SK1");
        input.add("K1/SK2");
        input.add("SK1/SSK1");
        input.add("K1/SK1/SSK1");
        input.add("K1/SK1/SSK2");
        input.add("K2");
        input.add("K2/SK1/SSK1");
        input.add("K2/SK1/SSK2");
        List<String> result = Departments.fillGaps(input);
        for (String s : result
        ) {
            System.out.println(s);
        }
    }
}