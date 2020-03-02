package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student {
    private int score;
    private String surname;

    public int getScore() {
        return score;
    }

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }

    public static List<Student> createStudentList() {
        return new ArrayList<>();
    }

    public static Map<String, Student> createStudentMap(List<Student> studentList) {
        return studentList.stream().distinct().collect(Collectors.toMap(
                i -> i.surname,
                i -> i
        ));
    }
}