package ru.job4j.collection.job;

import ru.job4j.collection.job.Job;
import ru.job4j.collection.job.jobcomparator.JobDescByNameUp;
import ru.job4j.collection.job.jobcomparator.JobDescByPriorityUp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    private static final String DELIMITER = "==========";
    public static void main(String[] args) {

        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(DELIMITER + "list before sort" + DELIMITER);
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);

        List<Job> jobList = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        jobList.sort(new JobDescByNameUp().thenComparing(new JobDescByPriorityUp()));
        System.out.println(jobList);
        System.out.println("====== multi function =======");
        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparingInt(Job::getPriority);
        Comparator<Job> combine = compareName.thenComparing(comparePriority);
        jobs.sort(combine);
        System.out.println(jobList);

    }

}