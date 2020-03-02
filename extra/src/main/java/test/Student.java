package test;

import java.util.Collections;
import java.util.List;

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

    public static void main(String[] args) {
        Student s1 = new Student("Bob", 12);
        Student s2 = new Student("Piter", 5);
        Student s3 = new Student("Voron", 32);
        Student s4 = new Student("Kot", 65);
        List<Student> list = new java.util.ArrayList<>(List.of(s1, s2, s3, s4));
        Collections.sort(list);
    }
}
