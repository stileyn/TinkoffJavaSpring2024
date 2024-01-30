package ru.stileyn.task_5;

import java.util.*;

public class Main {

    static class Graph {
        private int vertices;
        private List<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList[vertices];
            for (int i = 0; i < vertices; ++i) {
                this.adjacencyList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int from, int to) {
            this.adjacencyList[from].add(to);
            this.adjacencyList[to].add(from);
        }

        public List<Integer> shortestPath(int start, int end) {
            boolean[] visited = new boolean[vertices];
            int[] parent = new int[vertices];
            Arrays.fill(parent, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int neighbor : adjacencyList[current]) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        parent[neighbor] = current;
                    }
                }
            }

            return reconstructPath(start, end, parent);
        }

        private List<Integer> reconstructPath(int start, int end, int[] parent) {
            List<Integer> path = new ArrayList<>();
            int current = end;

            while (current != -1) {
                path.add(current);
                current = parent[current];
            }

            Collections.reverse(path);
            return path;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt(); // Количество комнат
            Graph graph = new Graph(n);

            // Считываем переходы между комнатами
            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.addEdge(u - 1, v - 1);
            }

            int q = scanner.nextInt(); // Количество вопросов

            for (int i = 0; i < q; i++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();

                List<Integer> shortestPath = graph.shortestPath(from - 1, to - 1);

                // Выводим номер комнаты, в которую нужно перейти
                System.out.println(shortestPath.get(1) + 1);
            }
        }
    }
}