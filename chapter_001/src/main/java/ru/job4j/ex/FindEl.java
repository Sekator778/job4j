package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException();
        }
        int rsl = -1;
        for (String s : value) {
            if (s.equals(key)) {
                rsl = 1;
            } else {
                rsl = 0;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] strings = {"Alex", "Bob"};
        try {
            System.out.println(indexOf(strings, null));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}