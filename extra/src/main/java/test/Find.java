package test;

import java.util.HashMap;

public class Find {
    public static void compare(String s1, String s2) {
        char[] one = s1.toCharArray();
        char[] two = s2.toCharArray();
        int len = Math.min(one.length, two.length);
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {

            map.put(one[i], two[i]);
        }
        map.forEach((x, y) -> System.out.println(x + " - " + y));
    }

    public static void main(String[] args) {
        compare("mama", "volvo");

    }
}
