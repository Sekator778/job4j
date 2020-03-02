package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.stream.matrix.Matrix;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrixTest {
    @Test
    public void whenMatrixToList() {
        Integer[][] array = {{1, 2, 3, 4},
                {5, 6, 7, 8}};
        List<Integer> result = new Matrix().convertMatrixToList(array);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(result, is(expect));
    }
}
