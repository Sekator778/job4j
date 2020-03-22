package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.job.Job;
import ru.job4j.collection.job.jobcomparator.JobDescByNameDown;
import ru.job4j.collection.job.jobcomparator.JobDescByNameUp;
import ru.job4j.collection.job.jobcomparator.JobDescByPriorityDown;
import ru.job4j.collection.job.jobcomparator.JobDescByPriorityUp;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
        @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByNameUp().thenComparing(new JobDescByPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("a", 0),
                new Job("a", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorByNameUp() {
        Comparator<Job> cmpNamePriority = new JobDescByNameUp();
        int rsl = cmpNamePriority.compare(
                new Job("Allo", 0),
                new Job("Ballo", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameDown() {
        Comparator<Job> cmpNamePriority = new JobDescByNameDown();
        int rsl = cmpNamePriority.compare(
                new Job("Allo", 0),
                new Job("Ballo", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityUp() {
        Comparator<Job> comparator = new JobDescByPriorityUp();
        int rsl = comparator.compare(
                new Job("Allo", 0),
                new Job("Ballo", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityDown() {
        Comparator<Job> comparator = new JobDescByPriorityDown();
        int rsl = comparator.compare(
                new Job("Allo", 0),
                new Job("Ballo", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}