package ru.stileyn.task_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testReplacePasswords() {
        // Тестирование замены паролей в строке
        String input = "This is a sample code123 with some secret code456 inside.";
        String expectedOutput = "This is a sample ??? with some secret ??? inside.";

        String result = Main.replacePasswords(input);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void testReplacePasswordsNoMatch() {
        // Тестирование, когда нет совпадений
        String input = "No passwords here.";
        String expectedOutput = "No passwords here.";

        String result = Main.replacePasswords(input);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void testReplacePasswordsMultipleMatches() {
        // Тестирование замены нескольких паролей
        String input = "code123 is a password, and so is code456.";
        String expectedOutput = "??? is a password, and so is ???.";

        String result = Main.replacePasswords(input);

        assertEquals(expectedOutput, result);
    }
}
