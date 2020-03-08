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
        return students.stream()
                .flatMap(student -> Stream.of(student)
                .collect(  // собираем объект Holder с unit и name// собираем карту
                Collectors.groupingBy(student::getName) // определяем группировку
                        Collector.of(
                                HashSet::new, // аккумулятор.
                                (set, el) -> // как добавлять данные.
                                        (left, right) -> { left.addAll(right); return left; } // для агрегации.
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
//public Set<String> ndLongTracks(List<Album> albums) {
//return albums.stream()
//. flatMap(album -> album.getTracks())
//. filter(track -> track.getLength() > 60)
//.map(track -> track.getName())
//.collect(toSet());
