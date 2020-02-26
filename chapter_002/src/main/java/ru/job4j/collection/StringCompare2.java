package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare2 implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        char[] value = left.toCharArray();
        char[] other = right.toCharArray();
        int len1 = value.length;
        int len2 = other.length;
        int lim = Math.min(len1, len2);
        for (int i = 0; i < lim; i++) {
            if (value[i] != other[i]) {
                result = Character.compare(value[i], other[i]);
                break;
            }
        }
        if (result == 0) {
            result = len1 - len2;
        }
        return result;
    }
}
