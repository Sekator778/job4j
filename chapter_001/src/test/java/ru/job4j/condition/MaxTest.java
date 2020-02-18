package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax1To2Then3() {
        assertThat(Max.max(-1, -2), is(-1));
    }

    @Test
    public void whenMax3() {
        assertThat(Max.max(-1, -2, 100), is(100));
    }

    @Test
    public void whenMax4() {
        assertThat(Max.max(-1, -2, -5, -7), is(-1));

    }
}