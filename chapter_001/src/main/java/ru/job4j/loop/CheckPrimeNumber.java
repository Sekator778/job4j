package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int number) {
        boolean result = true;
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= number - 1; i++) {
            if ((number % i) == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}