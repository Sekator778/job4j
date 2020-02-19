package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("the bus is going");
    }

    @Override
    public void passengers(int count) {
    }

    @Override
    public double fill(double fuel) {
        return 0;
    }
}
