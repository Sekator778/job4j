package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDiapason {
    /**
     * суть метода
     * в том что мы ему передадим
     * x -> чего сделать  (x)
     * в х подставляем впринцыпе все что хочем уже в самой функции
     * ля лучшего понимания смотреть файл
     * ru/job4j/lambda/FuncTest.java
     *
     * @param start - от ...
     * @param end - .. до
     * @param func - делаем это
     * @return - лист результов
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add((double) Math.round(func.apply((double) i)));
        }
        return list;
    }
}
