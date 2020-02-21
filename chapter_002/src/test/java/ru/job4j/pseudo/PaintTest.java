package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.stragery.Paint;
import ru.job4j.stragery.Square;
import ru.job4j.stragery.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.StringJoiner;

public class PaintTest {
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("8");
        pic.add("8 8  ");
        pic.add("8   8");
        pic.add("8888888");
        pic.add("");
        assertThat(this.out.toString(), is(pic.toString()));
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("8888888")
                                .add("8     8")
                                .add("8     8")
                                .add("8888888")
                                .add("")
                                .toString()
                )
        );
    }
}
