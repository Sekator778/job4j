package ru.job4j.array;

public class BarleyBreak {
    public static void main(String[] args) {
        int count = 0;
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            count++;
            for (int j = 0; j < array.length; j++) {
                array[i][j] = i + j + count;
            }
            count++;
        }
    }
}
