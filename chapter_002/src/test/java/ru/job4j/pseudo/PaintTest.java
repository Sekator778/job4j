package ru.job4j.pseudo;

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
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишущее в консоль.
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("8");
        pic.add("8 8  ");
        pic.add("8   8");
        pic.add("8888888");
        pic.add("");
        assertThat(new String(out.toByteArray()), is(pic.toString()));
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

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
