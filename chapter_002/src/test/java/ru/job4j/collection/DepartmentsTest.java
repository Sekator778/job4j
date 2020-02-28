package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.department.DepDescComp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortNaturalOrderUP() {
        List<String> input = Arrays.asList("K2/SK1/SSK1", "K1/SK1/SSK2", "K1", "K1/SK1", "K2/SK1", "K2");
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK2", "K2", "K2/SK1", "K2/SK1/SSK1");
        Collections.sort(input);
        List<String> result = new ArrayList<>(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortDown() {
        List<String> input = Arrays.asList("K2/SK1/SSK1", "K1/SK1/SSK2", "K1/SK1", "K2/SK1", "K2");
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK1", "K1/SK1", "K1/SK1/SSK2");
        input.sort(new DepDescComp());
        List<String> result = new ArrayList<>(input);
        assertThat(result, is(expect));
    }
}