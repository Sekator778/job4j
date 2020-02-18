package ru.job4j.condition;

public class Max {
    public static int max(int one, int two) {
        return one > two ? one : two;
    }

    public static int max(int one, int two, int three) {
        return one > two ? ((one > three) ? one : three) : (two > three) ? two : three;
    }

    public static int max(int one, int two, int three, int four) {
        return max(max(one, two), max(three, four));
    }
}