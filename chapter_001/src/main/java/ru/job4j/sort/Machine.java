package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    public static int[] change(int money, int price) {
        int[] coins = {10, 5, 2, 1};
        int[] rsl = new int[100];
        int size = 0, i = 0;
        money = money - price;
        while (money != 0) {
            if (money >= coins[i]) {
                money = money - coins[i];
                rsl[size++] = coins[i];
            } else {
                i++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}