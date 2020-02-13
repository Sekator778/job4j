package ru.job4j.condition;

public class Greeting {
    public static void main(String[] args) {
        byte age = 33;
        String idea = "I like Java";
        System.out.println(idea);
        idea += "But I am a newbie.";
        int year = 2020;
        idea += age;
        System.out.println(idea);
    }
}