package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int salary, double percent) {
        int year = 0;
        double sum = amount;
        while (sum > 0) {
            sum = sum + sum * percent / 100 - salary;
            year++;
        }
        return year;
    }
}