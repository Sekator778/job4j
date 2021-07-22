package ru.job4j.sort;

import org.junit.Assert;
import org.junit.Test;

public class MachineTest {
    @Test
    public void whenEquals() {
        int money = 100;
        int price = 100;
        int[] result = Machine.change(money, price);
        int[] expected = {};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void when50by35() {
        int money = 50;
        int price = 35;
        int[] result = Machine.change(money, price);
        int[] expected = {10, 5};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void when50by21() {
        int money = 50;
        int price = 21;
        int[] result = Machine.change(money, price);
        int[] expected = {10, 10, 5, 2, 2};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void when50by32() {
        int money = 50;
        int price = 32;
        int[] result = Machine.change(money, price);
        int[] expected = {10, 5, 2, 1};
        Assert.assertArrayEquals(expected, result);
    }
}