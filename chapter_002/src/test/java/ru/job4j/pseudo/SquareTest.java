package ru.job4j.pseudo;

import org.junit.Test;
import ru.job4j.stragery.Square;

import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("8888888")
                                .add("8     8")
                                .add("8     8")
                                .add("8888888")
                                .toString()
                )
        );
    }
}