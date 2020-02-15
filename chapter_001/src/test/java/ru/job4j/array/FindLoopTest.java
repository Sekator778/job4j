package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayNotHaveElement() {
        assertThat(new FindLoop().indexOf(new int[] {1, 2, 3, 4, -10, 0}, 7), is(-1));
    }

    @Test
    public void whenFind3() {
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenNotFind3() {
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 0;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }
    @Test
    public void whenFind3AllDiapason() {
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 4;
        int start = 0;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 4;
        assertThat(result, is(expect));
    }
}