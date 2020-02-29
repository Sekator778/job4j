package ru.job4j.collection.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int len1 = o1.length();
        int len2 = o2.length();
        boolean equal = o1.equals(o2.substring(0, len1));
        if ((len1 == len2) || (len1 < len2) && (!equal)) {
            result = o2.compareTo(o1);
        } else if ((len1 < len2) && (equal) || len1 > len2 && o2.equals(o1.substring(0, len2))) {
            result = o1.compareTo(o2);
        }
        return result;
    }
}

