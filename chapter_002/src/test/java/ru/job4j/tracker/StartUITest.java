package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenInit() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), Arrays.asList(new UserAction[]{action}));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenFindAllTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("how how");
        tracker.add(item);
        ShowAllAction act = new ShowAllAction();
        act.execute(new StubInput(new String[]{}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("name: " + item.getName() + " id:" + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenFindByNameActionTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("find me");
        tracker.add(item);
        FindByNameAction operate = new FindByNameAction();
        operate.execute(new StubInput(new String[]{"find me"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("name: " + item.getName() + " id:" + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }


}
