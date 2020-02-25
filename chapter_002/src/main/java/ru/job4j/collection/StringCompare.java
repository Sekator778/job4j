package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] value = left.toCharArray();
        char[] other = right.toCharArray();
        int len1 = value.length;
        int len2 = other.length;
        int lim = Math.min(len1, len2);
        for (int i = 0; i < lim; i++) {
            if (value[i] != other[i]) {
                return Character.compare(value[i], other[i]);
            }
        }
        return len1 - len2;
    }
}
