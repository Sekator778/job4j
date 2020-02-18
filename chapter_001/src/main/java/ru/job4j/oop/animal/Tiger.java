package ru.job4j.oop.animal;

public class Tiger extends Predator {
    public Tiger() {
        super();
        System.out.println("I'm Tiger");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
    }
}
