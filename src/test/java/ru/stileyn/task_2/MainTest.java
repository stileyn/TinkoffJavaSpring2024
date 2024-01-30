package ru.stileyn.task_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {

    @Test
    public void testCountBookStacks() {
        int[] bookHeights = {1, 2, 3, 4, 5};
        int[] expectedStacks = {1, 1, 1, 1, 1};

        int[] result = Main.countBookStacks(bookHeights);

        assertArrayEquals(expectedStacks, result);
    }

    @Test
    public void testCountBookStacksRepeatedHeights() {
        int[] bookHeights = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] expectedStacks = {2, 2, 2, 2};

        int[] result = Main.countBookStacks(bookHeights);

        assertArrayEquals(expectedStacks, result);
    }

    @Test
    public void testCountBookStacksEmptyArray() {
        int[] bookHeights = {};
        int[] expectedStacks = {};

        int[] result = Main.countBookStacks(bookHeights);

        assertArrayEquals(expectedStacks, result);
    }

    @Test
    public void testCountBookStacksSingleHeight() {
        int[] bookHeights = {5};
        int[] expectedStacks = {0, 0, 0, 0, 1};

        int[] result = Main.countBookStacks(bookHeights);

        assertArrayEquals(expectedStacks, result);
    }
}
