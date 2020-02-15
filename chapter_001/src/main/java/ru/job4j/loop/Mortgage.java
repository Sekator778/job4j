package ru.job4j.loop;

public class Mortgage {

    public int year(double amount, double salary, double percent) {
        int year = 0;
        do {
            amount = amount + (amount / 100 * percent);
            amount = amount - salary;
            year++;
        } while (amount > 0);
        return year;
    }
}