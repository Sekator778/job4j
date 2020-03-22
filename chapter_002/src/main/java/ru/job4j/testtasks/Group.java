package ru.job4j.testtasks;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream() // stream с листа студентов
                .flatMap(student -> {
                    List<Holder> holders = new ArrayList<>();
                    for (String section : student.getUnits()
                    ) {
                        holders.add(new Holder(section, student.getName()));
                    }
                    return holders.stream();
                })
                .collect(
                        Collectors.groupingBy(a -> a.key,
                                Collector.of(
                                        HashSet::new,
                                        (set, el) -> set.add(el.value),
                                        (left, right) -> {
                                            left.addAll(right);
                                            return left;
                                        }
                                        )
                        )
                );
    }

    static class Holder {
    String key, value;

    Holder(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
}

