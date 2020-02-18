package ru.job4j.pojo;

public class Book {
    private String name;
    private int count;

    public Book(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Book {" +
                "name = '" + name + '\'' +
                ", count = " + count +
                '}';
    }
}
