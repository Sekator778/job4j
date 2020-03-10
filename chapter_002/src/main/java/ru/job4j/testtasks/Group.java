package ru.job4j.testtasks;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return null;
//        Map<String, Set<String>> result = students.stream() // stream с листа студентов
//                .flatMap(student -> student.getUnits().stream() // тут разворачиваем внутрений стрим где список секций
//                        .collect(Collectors.groupingBy(Student::getName) // ? как тут групировать по названию секции ?
//                                .Collectors.of(HashSet::new, (set, el) -> (left, right) -> {
//                                            left.addAll(right);
//                                            return left;
//                                        } // для агрегации.
//                                )
//                        )
//                );
//    }
}

static class Holder {
    String key, value;

    Holder(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
}

