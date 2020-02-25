package ru.job4j.collection.jobcomparator;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobDescByNameDown implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}