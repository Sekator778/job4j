package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" + "name='" + name + '\'' + ", spent=" + spent + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );
        // ===== filter ===
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);
        // ==== preobrazovanie ===
        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);
        // === 3. Упрощение. =====
        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);    //- каждое значение task.spent - нужно сложить с начальным значение 0L.
        System.out.println(total);
    }
}