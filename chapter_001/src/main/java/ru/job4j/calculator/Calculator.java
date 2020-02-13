package ru.job4j.calculator;

public class Calculator {

    public static void plus(int first, int second) {
        int result = first + second;
        System.out.println(result);
    }

    public static void main(String[] args) {
        Calculator.plus(1, 2);
        Calculator.plus(10, 11);
        Calculator.plus(100, 500);
        Calculator.plus(4, 2);
        Calculator.plus(3, 5);
    }
}
//1. В комментарии к задаче напишите код, который вызывает метод plus с аргументами 100 и 500, 4 и 2, 3 и 5.