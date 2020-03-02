package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

/**
 * Stream API.
 *
 * Были добавлены 4 новых метода.
 * Stream.takingWhile - это метод позволяет получать поток данных до тех пор, пока он проходит фильтр.
 * Эту конструкцию удобно использовать с отсортированными данными.
 *
 * Stream.dropWhile - это метод позволяет получать поток данных после того, как фильтр не проходит.
 *
 * Stream.ofNullable - сделает из элементов поток, если элемент равен null. то возвращает пустой поток.
 *
 * Stream.iterate(seed, predicate, next) - по сути это for цикл с индексом.
 *
 * Это элемент позволяет фильтровать элементы.
 */
public class StreamApiImprov {
    public static void main(String[] args) {
        List.of(2, 4, 3, 4).stream()
                .takeWhile(v -> v % 2 == 0)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);
        System.out.println();
        System.out.println("=======================");

        List.of(2, 4, 3, 4).stream()
                .dropWhile(v -> v % 2 == 0)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);
        System.out.println();
        System.out.println("=======================");

        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);
        System.out.println();
        System.out.println("=======================");

        Stream.iterate(0, i -> i < 10, i -> i + 1)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);
    }

}
