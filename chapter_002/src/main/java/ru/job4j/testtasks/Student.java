package ru.job4j.testtasks;

import java.util.Set;

/**
 * name - name student;
 *
 */
public class Student {
    private String name;
    private Set<String> units;
    private int age;

    public Student(String name, Set<String> units, int age) {
        this.name = name;
        this.units = units;
        this.age = age;
    }

    @Override
    public String toString() {
        return getName();
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getUnits() {
        return units;
    }
}
