package ru.job4j.calculator;

/**
 * Calculator for Math operation
 *

 */
public class Calculator {

    /**
     * Method plus
     * @param first first argument
     * @param second second argument
     * @return result math operation
     *
     */
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