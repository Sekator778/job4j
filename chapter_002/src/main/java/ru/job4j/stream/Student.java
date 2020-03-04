package ru.job4j.stream;

import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
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
        return surname + " : " + score;
    }

    @Override
    public int compareTo(Student s2) {
        return Integer.compare(s2.getScore(), this.getScore());
    }

    public static Map<String, Student> createStudentMap(List<Student> studentList) {
        return studentList.stream().distinct().collect(Collectors.toMap(
                i -> i.surname,
                i -> i
        ));
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(s -> s.getScore() > bound)
                .collect(Collectors.toList());
    }
}
