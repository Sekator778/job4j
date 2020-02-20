package ru.job4j.ex;

public class Fact {
     public int calc(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Start must be greater than 1.");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}