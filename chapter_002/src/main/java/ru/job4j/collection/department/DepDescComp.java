package ru.job4j.collection.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        if (o1.length() == o2.length()
                || o1.length() < o2.length() && !o1.equals(o2.substring(0, o1.length()))) {
            result = o2.compareTo(o1);
        } else
        if (o1.length() < o2.length() && o1.equals(o2.substring(0, o1.length()))
                || o1.length() > o2.length() && o2.equals(o1.substring(0, o2.length()))) {
            result = o1.compareTo(o2);
        }
        return result;
    }
}

