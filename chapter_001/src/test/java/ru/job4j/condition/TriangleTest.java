package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        boolean result = Triangle.exist(new Point(0, 0), new Point(0, 2), new Point(2, 0));
        assertThat(result, is(true));
    }
    @Test
    public void whenExist1() {
        assertThat(Triangle.exist(new Point(0, 3), new Point(0, 3), new Point(3, 3)), is(false));
    }
}