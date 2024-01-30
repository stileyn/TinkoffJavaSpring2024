package ru.stileyn.task_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] d = new int[n];
            int[] c = new int[n];
            int[] s = new int[n];

            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt();
                c[i] = sc.nextInt();
                s[i] = sc.nextInt();
            }

            Integer[] order = new Integer[n];
            for (int i = 0; i < n; i++) {
                order[i] = i;
            }

            Arrays.sort(order, Comparator.comparingInt(a -> s[a]));

            int currentDay = 1;

            for (int i : order) {
                if (currentDay <= d[i]) {
                    currentDay = d[i];
                }

                if (currentDay + c[i] - 1 <= s[i]) {
                    currentDay += c[i];
                } else {
                    System.out.println("NO");
                    return;
                }
            }

            System.out.println("YES");
        }
    }
}