package ru.job4j.collection.job.jobcomparator;

import ru.job4j.collection.job.Job;

import java.util.Comparator;

public class JobDescByNameUp implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}