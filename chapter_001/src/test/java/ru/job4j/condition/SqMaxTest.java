package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenSqMax() {
        SqMax check = new SqMax();
        int result = check.max(6, 4, 7, 5);
        assertThat(result, is(7));
    }

}
