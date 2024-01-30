package ru.stileyn.task_4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testMainWithExampleInput() {
        String input = "3 2 5\n1 2 3\n4 5 6\n1 2\n2 3";
        assertEquals(12, Main.runAlgorithmWithInput(input));
    }

    @Test
    public void testMainWithDifferentInput() {
        String input = "4 3 7\n2 3 4 5\n1 2 3 4\n1 2\n2 3\n3 4";
        assertEquals(11, Main.runAlgorithmWithInput(input));
    }

    // Add more test cases based on different scenarios

    static class Main {
        public static int runAlgorithmWithInput(String input) {
            Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int g = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            int[][] dp = new int[n + 1][g + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= g; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= b[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - b[i - 1]] + a[i - 1]);
                        for (int neighbor : adjList.get(i)) {
                            dp[i][j] = Math.max(dp[i][j], dp[neighbor][j - b[i - 1]] + a[i - 1]);
                        }
                    }
                }
            }

            return dp[n][g];
        }
    }
}
