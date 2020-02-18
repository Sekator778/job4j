package ru.job4j.oop.animal;

public class Animal {
    private String name;

    public Animal(String name) {
        System.out.println("constructor with parameter");
        this.name = name;
    }

    public Animal() {
        System.out.println("I'm Animal");
    }
}
