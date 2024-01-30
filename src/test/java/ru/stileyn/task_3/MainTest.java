package ru.stileyn.task_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testMainWithValidSchedule() {
        String input = "3\n1 2 5\n2 1 7\n3 3 9";
        assertEquals("YES", TestUtils.runMainWithInputString(input));
    }

    @Test
    public void testMainWithInvalidSchedule() {
        String input = "3\n1 2 5\n2 1 6\n3 3 9";
        assertEquals("NO", TestUtils.runMainWithInputString(input));
    }

    @Test
    public void testMainWithEqualDays() {
        String input = "3\n1 2 5\n1 1 7\n1 3 9";
        assertEquals("NO", TestUtils.runMainWithInputString(input));
    }

    static class TestUtils {
        static String runMainWithInputString(String input) {
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(out));

            Main.main(new String[0]);

            return out.toString().trim();
        }
    }
}
