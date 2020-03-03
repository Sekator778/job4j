package ru.job4j.stream;

import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Student> {
    private int score;
    private String surname;

    public int getScore() {
        return score;
    }

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return surname + " : " + score;
    }

    @Override
    public int compare(Student s1, Student s2) {
        int rez;
        if (s1 == null && s2 == null) {
            rez = 0;
        } else if (s1 == null) {
            rez = 1;
        } else if (s2 == null) {
            rez = -1;
        } else {
            rez = Integer.compare(s2.getScore(), s1.getScore());
        }
        return rez;
    }

    public static Map<String, Student> createStudentMap(List<Student> studentList) {
        return studentList.stream().distinct().collect(Collectors.toMap(
                i -> i.surname,
                i -> i
        ));
    }

    public static List<Student> levelOf(List<Student> students, int bound) {

        return students.stream()
                .sorted(new Student())
                .flatMap(Stream::ofNullable)
                .takeWhile(s -> s.getScore() > bound)
                .collect(Collectors.toList());
    }
}
