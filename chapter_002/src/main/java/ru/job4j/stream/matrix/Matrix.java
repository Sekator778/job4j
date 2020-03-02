package ru.job4j.stream.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    /**
     * Для того, чтобы преобразовать список списков нужно использовать flatMap
     *
     * @param array - матрицa Integer[][]
     */
    public List<Integer> convertMatrixToList(Integer[][] array) {
        return Arrays.stream(array).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
