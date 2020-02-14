package ru.job4j.loop;

public class Factorial {

    public static int calc(int n) {
        int result;
        if (n == 0) {
            return 1;
        } else {
            result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        }
        return result;
    }
}