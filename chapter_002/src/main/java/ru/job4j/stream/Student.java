package ru.job4j.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }


    public static List<Student> createStudentList() {
        Student s1 = new Student("Bob", 12);
        Student s2 = new Student("Piter", 5);
        Student s3 = new Student("Voron", 32);
        Student s4 = new Student("Kot", 65);
        Student s5 = new Student(null, 34);
        List<Student> list = List.of(s1, s2, s3, s4, s5);

        return list;
    }

    public static Map<String, Student> createStudentMap(List<Student> studentList) {
        return studentList.stream().distinct().collect(Collectors.toMap(
                i -> i.surname,
                i -> i
        ));
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        Collections.sort(students);

        return students.stream()
                .flatMap(Stream::ofNullable)
                .takeWhile(s -> (s.score > bound))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> studentList = createStudentList();
        studentList = levelOf(studentList, 15);
        studentList.forEach(System.out::println);
    }
}
