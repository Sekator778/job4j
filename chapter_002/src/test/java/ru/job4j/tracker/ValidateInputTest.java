package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenInvalidInput() {
        Consumer<String> stringConsumer = System.out::println;
        ValidateInput input = new ValidateInput(new StubInput(new String[]  {"one", "1"}), stringConsumer);
        input.askInt("Enter");
        assertThat(
                out.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
    }

    @Test
    public void whenMaxNumberInput() {
        Consumer<String> stringConsumer = System.out::println;
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"7", "7"}), stringConsumer);
        input.askInt("Enter", 1);
        assertThat(
                out.toString(),
                is(String.format(""))
        );
    }

        @Test
        public void whenInvalidInput2() {
            ByteArrayOutputStream mem = new ByteArrayOutputStream();
            PrintStream out = System.out;
            System.setOut(new PrintStream(mem));
            Consumer<String> stringConsumer = System.out::println;
            ValidateInput input = new ValidateInput(
                    new StubInput(new String[] {"one", "1"}),
                    stringConsumer
            );
            input.askInt("Enter");
            assertThat(
                    mem.toString(),
                    is(String.format("Please enter validate data again.%n"))
            );
            System.setOut(out);
    }
}