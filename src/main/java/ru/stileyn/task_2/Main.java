package ru.stileyn.task_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int countBook = sc.nextInt();
            int[] bookHeights = new int[countBook];

            for (int i = 0; i < countBook; i++) {
                bookHeights[i] = sc.nextInt();
            }

            int[] stacks = countBookStacks(bookHeights);

            Arrays.sort(stacks);

            System.out.println(stacks.length);

            for (int stack : stacks) {
                System.out.print(stack + " ");
            }
        }
    }

    static int[] countBookStacks(int[] bookHeights) {
        int max = Arrays.stream(bookHeights).max().orElse(0);
        int[] stacks = new int[max];

        for (int bookHeight : bookHeights) {
            stacks[bookHeight - 1]++;
        }

        return stacks;
    }
}