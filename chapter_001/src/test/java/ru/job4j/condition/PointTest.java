package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void when2dPoint() {
        Point point = new Point(0, 0);
        Point point1 = new Point(0, 1);
        assertThat(point.distance(point1), is(1.0));
    }

    @Test
    public void when3dPoint() {
        Point point = new Point(0, 0, 0);
        Point point1 = new Point(0, 1, 0);
        assertThat(point.distance3d(point1), is(1.0));

    }
}
