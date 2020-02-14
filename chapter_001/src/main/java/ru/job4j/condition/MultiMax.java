package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        if (first > second && first > third){
            return first;
        }else if (second > first && second > third){
            return second;
        }else return third;
    }
}