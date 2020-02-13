package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }
//    @Test
//    public void rubleToEuro1() {
//        int in1 = 210;
//        int expected = 2;
//        int out = Converter.rubleToEuro(in1);
//        Assert.assertEquals(expected, out);
//    }

    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

//    @Test
//    public void rubleToDollar1() {
//        int in = 180;
//        int expected = 2;
//        int out = Converter.rubleToDollar(in);
//        Assert.assertEquals(expected, out);
//    }
}