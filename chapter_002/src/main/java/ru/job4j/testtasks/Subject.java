package ru.job4j.testtasks;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class Subject {
    public static void main(String[] args) {
        Set<String> section1 = new HashSet<>(Arrays.asList("1l, 2l"));
        Set<String> section2 = new HashSet<>(Arrays.asList("1l"));
        Set<String> section3 = new HashSet<>(Arrays.asList("1l"));
        Set<String> section4 = new HashSet<>(Arrays.asList("1l, 2l, 3l"));

        Student student1 = new Student("Alex", section1, 30);
        Student student2 = new Student("Bob", section2, 30);
        Student student3 = new Student("Nick", section3, 40);
        Student student4 = new Student("Lora", section4, 21);
        Student student5 = new Student("Dick", section4, 13);
        Student student6 = new Student("Gay", section4, 33);

        List<Student> studentList = new ArrayList<>() {
            {
                add(student1);
                add(student2);
                add(student3);
                add(student4);
                add(student5);
                add(student6);
            }
        };
        // подсчет количество чего то
        long count = studentList.stream()
                .filter(student -> student.getAge() > 32)
                .count();
        System.out.println("old more 32 is: " + count);
        // print name
        long count2 = studentList.stream()
                .filter(student -> {
                    System.out.println(student.getName());
                    return student.getAge() > 32;
                })
                .count();
        // collect method
        List<Student> collectStudent = Stream.of(student1, student2, student3, student4)
                .collect(Collectors.toList());
        // map easy
        List<String> strings = Stream.of("one", "two", "three")
                .map(s -> s.toUpperCase())
                .map(s -> s.replace("O", "1"))
                .collect(Collectors.toList());
        System.out.println(strings.toString());
        System.out.println("===filter=======");
        List<String> strings1 = strings.stream()
                .filter(s -> isDigit(s.charAt(0)))
                .collect(Collectors.toList());
        System.out.println(strings1.toString());
        System.out.println("====flatmap=======");
        List<String> stringAll = Stream.of(Arrays.asList("one, two"),
                Arrays.asList("three, four"),
                Arrays.asList("five, six"))
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());
        List<Student> studentsNameAge = Stream.of(
                new Student("Dilon", 24),
                new Student("Lola", 24),
                new Student("Petr", 36),
                new Student("Lisa", 98),
                new Student("John", 80),
                new Student("Joe", 80)
        )
                .collect(Collectors.toList());

        List<String> studentsSectionAll = collectStudent.stream()
                .flatMap(s -> s.getUnits().stream())
                .collect(Collectors.toList());

        System.out.println(studentsSectionAll.toString());

        long count1l = collectStudent.stream()
                .flatMap(student -> student.getUnits().stream())
                .filter(str -> str.startsWith("1l"))
                .count();
        System.out.println("count 1l: " + count1l);
        System.out.println("=====reduce=====");
        Integer reducer = studentsNameAge.stream()
                .map(student -> student.getAge())
                .reduce(0, (a, b) -> (a + b));
        System.out.println("all age: " + reducer);

        System.out.println("===========groupingByAge==============");

        Map<Integer, List<Student>> studentByAge = studentsNameAge.stream()
                .collect(Collectors.groupingBy(Student::getAge));


        Map<Integer, List<Student>> rsl = studentList.stream()
                .collect(Collectors.groupingBy(Student::getAge));
        for (Map.Entry<Integer, List<Student>> entry : rsl.entrySet()) {
            System.out.println("Students with " + entry.getKey() + " age are " + entry.getValue());
        }
        System.out.println("===========groupingBySection==============");

        Map<String, Set<String>> result =
                studentList.stream() // stream с листа студентов
                        .flatMap(student -> { // строим лист из нового обьекта холдер
                            List<Group.Holder> holders = new ArrayList<>();
                            for (String section : student.getUnits()
                            ) {
                                holders.add(new Group.Holder(section, student.getName()));
                            }
                            return holders.stream();
                        }).collect(
                        Collectors.groupingBy(t -> t.key,
                                Collector.of(
                                        HashSet::new,
                                        (set, el) -> set.add(el.value),
                                        (left, right) -> {
                                            left.addAll(right);
                                            return left;
                                        })));
        for (Map.Entry<String, Set<String>>  entry : result.entrySet()) {
            System.out.println("Section " + entry.getKey() + " students are " + entry.getValue());
        }
        System.out.println("групировка по интресам");

    }
}
