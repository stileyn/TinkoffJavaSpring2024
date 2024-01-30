package ru.stileyn.task_5;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testShortestPath() {
        Main.Graph graph = new Main.Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        List<Integer> shortestPath = graph.shortestPath(0, 4);

        // Ожидаемый путь: [0, 1, 2, 4]
        assertEquals(List.of(0, 1, 2, 4), shortestPath);
    }

    @Test
    public void testShortestPathDisconnectedGraph() {
        Main.Graph graph = new Main.Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);

        List<Integer> shortestPath = graph.shortestPath(0, 3);

        // Ожидаемый результат: Путь не существует (null)
        assertEquals(null, shortestPath);
    }

    @Test
    public void testShortestPathSameNode() {
        Main.Graph graph = new Main.Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        List<Integer> shortestPath = graph.shortestPath(1, 1);

        // Ожидаемый путь: [1]
        assertEquals(List.of(1), shortestPath);
    }

}
