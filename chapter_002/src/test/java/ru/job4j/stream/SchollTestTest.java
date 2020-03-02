package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchollTestTest {
    private final List<Student> studentList = createStudentList();
    public List<Student> createStudentList() {
        Student student = new Student("Alex", 99);
        Student student1 = new Student("Nick", 100);
        Student student2 = new Student("Masha", 69);
        Student student3 = new Student("Bob", 34);

        return new ArrayList<>(List.of(student, student1, student2, student3));
    }

    @Test
    public void thenScoreMore70() {
        List<Student> classA = SchoolTest.classA(studentList);
        List<Student> expectA = new ArrayList<>(List.of(
               studentList.get(0),
               studentList.get(1)
        ));
        assertThat(classA, is(expectA));
    }

    @Test
    public void thenScoreMore50Less70() {
        List<Student> classB = SchoolTest.classB(studentList);
        List<Student> expectB = new ArrayList<>(List.of(
                studentList.get(2)
        ));
        assertThat(classB, is(expectB));
    }

    @Test
    public void thenScoreLess50() {
        List<Student> classC = SchoolTest.classC(studentList);
        List<Student> expectC = new ArrayList<>(List.of(
                studentList.get(3)
        ));
        assertThat(classC, is(expectC));
    }
}
