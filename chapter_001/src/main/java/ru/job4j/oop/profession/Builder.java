package ru.job4j.oop.profession;

public class Builder extends Engineer {
    String dopysk;

    public String getEducation() {
        return getEducation() + dopysk;
    }
}
