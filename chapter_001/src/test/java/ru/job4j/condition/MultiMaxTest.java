package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax1() {
        assertThat(new MultiMax().max(0, -2, -10), is(0));
    }
    @Test
    public void whenSecondMax2() {
        assertThat(new MultiMax().max(100, -2000, 10), is(100));
    }
}