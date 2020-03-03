package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class StudentTest {
        Student s1 = new Student("Bob", 12);
        Student s2 = new Student("Piter", 5);
        Student s3 = new Student("Voron", 32);
        Student s4 = new Student("Kot", 65);
        Student s5 = new Student("lol", 34);
       private final ArrayList<Student> students = new ArrayList<>(Arrays.asList(s1, s2, null, s3, s4, null, s5));

        @Test
    public void testWithoutNullStudentsAndMore30() {
            ArrayList<Student> result = new ArrayList<>(Student.levelOf(students, 30));
            ArrayList<Student> expected = new ArrayList<>(Arrays.asList(s4, s5, s3));
            assertThat(result, is(expected));
        }
}
