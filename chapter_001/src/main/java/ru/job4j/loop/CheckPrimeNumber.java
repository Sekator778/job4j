package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int number) {
        boolean result = false;
        if (number == 2) return true;
        for (int i = 2; i <= number - 1; i++) {
            if ((number % i) == 0) {
                result = false;
                break;
            } else result = true;
        }return result;
    }
}