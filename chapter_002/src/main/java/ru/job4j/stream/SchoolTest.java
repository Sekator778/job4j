package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;

public class SchoolTest {
    public static List<Student> classA(List<Student> students) {
        Predicate<Student> predicateA = item -> (item.getScore() >= 70) && (item.getScore() <= 100);
        return new School().collect(students, predicateA);
    }
    public static List<Student> classB(List<Student> students) {
        Predicate<Student> predicateB = item -> (item.getScore() >= 50) && (item.getScore() < 70);
        return new School().collect(students, predicateB);
    }
    public static List<Student> classC(List<Student> students) {
        Predicate<Student> predicateC = item -> (item.getScore() >= 0) && (item.getScore() < 50);
        return new School().collect(students, predicateC);
    }
}
