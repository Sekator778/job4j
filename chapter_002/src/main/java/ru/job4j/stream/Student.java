package ru.job4j.stream;

public class Student {
    private int score;

    public int getScore() {
        return score;
    }

    public Student(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}
