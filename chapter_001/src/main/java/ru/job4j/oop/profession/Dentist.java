package ru.job4j.oop.profession;

public class Dentist extends Doctor {
    private int count;

    public String doAction() {
        return this.getEducation();
    }
}
