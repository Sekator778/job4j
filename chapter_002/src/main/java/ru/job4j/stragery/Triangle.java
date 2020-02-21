package ru.job4j.stragery;

import java.util.StringJoiner;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("8");
        pic.add("8 8  ");
        pic.add("8   8");
        pic.add("8888888");
        return pic.toString();
    }
}
