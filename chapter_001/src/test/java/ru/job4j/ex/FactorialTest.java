package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class FactorialTest {
    @Test(expected = IllegalArgumentException.class)
    public void less1() {
        new Fact().calc(-5);
    }

    @Test
    public void fact8() {
        Assert.assertThat(new Fact().calc(8), is(40320));
    }
}
