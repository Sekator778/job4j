package ru.job4j.calculator;

public class MathFunc {

    public static int func1(int x) {
        int y = x * x + 1;
        return y;
    }

    public static int func2(int x) {
        int y = 1 / x;
        return y;
    }
//1. В комментарии к задаче напишите код. В коде необходимо
// вызвать метод func1 с аргументом x = 100, а результат вычисления функции записать в переменную result.
    public static void main(String[] args) {
        int result1 = MathFunc.func1(3);
        int result2 = MathFunc.func1(5);
        int total = result1 + result2;
        System.out.println(total);
        int result = func1(100);
    }
}