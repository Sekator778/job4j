package ru.job4j.array;

import java.util.Arrays;

public class ArrayDefinition {
    public static void main(String[] args) {
        short[] ages = new short[10];
        String[] surnames = new String[100500];
        float[] prices = new float[40];

        String[] names = new String[4];
        names[0] = "Petr Arsentev";
        names[1] = "Petr";
        names[2] = "Arsentev";
        names[3] = "1111";
        Arrays.stream(names).forEach(System.out::println);
    }
}

