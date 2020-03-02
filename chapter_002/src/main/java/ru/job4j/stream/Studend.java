package ru.job4j.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * name - ФИО студента,
 * scope - бал аттестата.
 */
public class Studend implements Comparable<Studend> {
    private String name;
    private int scope;

    public int getScope() {
        return scope;
    }

    public Studend(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public String toString() {
        return name + " : " + scope;
    }

    @Override
    public int compareTo(Studend o) {
        return Integer.compare(scope, o.scope);
    }

    public static List<Studend> levelOf(List<Studend> students, int bound) {
        Collections.sort(students);

        return students.stream()
                .flatMap(Stream::ofNullable)
                .takeWhile(s -> (s.getScope() > bound))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Studend s1 = new Studend("Bob", 12);
        Studend s2 = new Studend("Piter", 5);
        Studend s3 = new Studend("Voron", 32);
        Studend s4 = new Studend("Kot", 65);
        Studend s5 = new Studend(null, 34);
        List<Studend> list = List.of(s1, s2, s3, s4, s5);

        list = levelOf(list, 15);

        list.forEach(System.out::println);
    }
}
