package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {
    /**
     * математическая функция
     *
     * @param start  - от какого числа
     * @param finish - до какого числа
     * @param value  - 2й операнд (1й это от start до finish)
     * @param op     - математическая операция которая идет в функцию -> ...
     * @param media  - это интерфейс Consumer он х.з. пока %)
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int i = start; i != finish; i++) {
            media.accept(op.apply(value, i));
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.multiple(
                0, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiply %s * %s = %n", value, index, result);
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}