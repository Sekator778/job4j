package ru.job4j.oop.profession;

public class Surgeon extends Doctor {
    private String hardOperation;
    private int count;

    public int doOperation(String hardOperation) {
        return count;
    }

    public String getName() {
        return this.getName() + this.getSurname();
    }
}
