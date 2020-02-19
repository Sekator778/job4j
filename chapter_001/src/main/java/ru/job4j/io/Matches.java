package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 11;
        int a = 0;
        while (count > 0) {
            System.out.println("1 Игрок берет спички");
            a = Integer.parseInt(scanner.nextLine());
            if (a > 3) {
                System.out.println("За раз берем от 1 дло 3 спичек");
                a = 0;
                continue;
            }
            count -= a;
            System.out.println("На столе осталось " + count + " спичек");
            if (count == 0) {
                System.out.println("Выиграл 1й игрок");
                break;
            }
            System.out.println("2 Игрок берет спички");
            a = Integer.parseInt(scanner.nextLine());
            if (a > 3) {
                System.out.println("За раз берем от 1 дло 3 спичек");
                a = 0;
                continue;
            }
            count -= a;
            System.out.println("На столе осталось " + count + " спичек");
            if (count == 0) {
                System.out.println("Выиграл 2й игрок");
                break;
            }
        }
    }
}
