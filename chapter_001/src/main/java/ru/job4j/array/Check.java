package ru.job4j.array;

public class Check {
    public static boolean mono(boolean[] data) {
        boolean etalon = data[0];
        for (boolean x : data) {
            if (x != etalon) {
               return false;
            }
        }return true;
    }
}