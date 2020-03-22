import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CycleShiftTest {
    @Test
    public void multi() {
        CycleShift cycle = new CycleShift(new int[]{1, 2, 3, 4, 5});
        int[] result = cycle.shift(2);
        assertThat(result, is(new int[]{4, 5, 1, 2, 3}));
    }

    @Test
    public void one() {
        CycleShift cycle = new CycleShift(new int[]{1});
        int[] result = cycle.shift(2);
        assertThat(result, is(new int[]{1}));
    }
}
