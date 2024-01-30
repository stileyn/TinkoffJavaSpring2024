package ru.stileyn.task_4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        System.out.println(dp[n][g]);
    }
}