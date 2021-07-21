package ru.job4j.array;

public class MatrixSum {
    public static int sum(int[][] array) {
        int rsl = 0;
        for (int[] arr :
                array) {
            for (int i :
                    arr) {
                rsl += i;
            }
        }
        return rsl;
    }
}