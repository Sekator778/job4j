package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array2 {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (int i = 0; i < list.size(); i++, cell++) {
            if (cell < cells) {
                array[row][cell] = list.get(i);
            } else {
                row++;
                cell = 0;
                array[row][cell] = list.get(i);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}