package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(100);
        Battery battery2 = new Battery(50);
        System.out.println("first battery1: " + battery1.load + ". second battery1: " + battery2.load);
        battery1.exchange(battery2);
        System.out.println("After charge");
        System.out.println("first battery1: " + battery1.load + ". second battery1: " + battery2.load);
    }
}
