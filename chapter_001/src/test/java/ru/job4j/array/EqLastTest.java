package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

public class EqLastTest {
    @Test
    public void whenEq() {
        int[] left = {1, 2, 3};
        int[] right = {5, 4, 3};
        boolean result = EqLast.check(left, right);
        Assert.assertTrue(result);
    }

    @Test
    public void whenNotEq() {
        int[] left = {1, 2, 3};
        int[] right = {3, 3, 4};
        boolean result = EqLast.check(left, right);
        Assert.assertFalse(result);
    }
}