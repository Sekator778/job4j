package ru.job4j.array;

import java.util.Arrays;

/**
 * Массив на 10 элементов типа short с именем ages.
 * Массив на 100500 элементов типа String c именем surnames.
 * Массив на 40 элементов типа float с именем prices.
 */
public class ArrayDefinition {
    public static void main(String[] args) {
        short[] ages = new short[10];
        String[] surnames = new String[100500];
        float[] prices = new float[40];
        System.out.println("Размер массива равен: " + ages.length);
        System.out.println("Размер массива равен: " + surnames.length);
        System.out.println("Размер массива равен: " + prices.length);
    }
}

