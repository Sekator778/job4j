package ru.job4j.collection.job.jobcomparator;

import ru.job4j.collection.job.Job;

import java.util.Comparator;

public class JobDescByPriorityUp implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
