package ru.job4j.collection;

import ru.job4j.collection.jobcomparator.JobDescByNameUp;
import ru.job4j.collection.jobcomparator.JobDescByPriorityUp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);

        List<Job> jobList = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobList, new JobDescByNameUp().thenComparing(new JobDescByPriorityUp()));
        System.out.println(jobList);
    }

}