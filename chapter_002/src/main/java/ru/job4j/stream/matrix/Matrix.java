package ru.job4j.stream.matrix;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    /**
     * Для того, чтобы преобразовать список списков нужно использовать flatMap
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        System.out.println(
                matrix.stream().flatMap(Collection::stream).collect(Collectors.toList())
        );

        Integer[][] array = {{1, 2, 3, 4},
                {5, 6, 7, 8}};
        System.out.println(
                Arrays.stream(array).flatMap(Arrays::stream).collect(Collectors.toList()));
    }
}
