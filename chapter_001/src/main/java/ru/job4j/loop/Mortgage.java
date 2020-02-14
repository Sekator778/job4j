package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int salary, int percent) {
        int year = 0;
        do {
            amount = amount + percent;
            amount = amount - salary;
            year++;
        } while (amount > 0);
        return year;
    }
}