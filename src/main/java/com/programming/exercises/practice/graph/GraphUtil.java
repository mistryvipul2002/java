package com.programming.exercises.practice.graph;

import com.programming.exercises.practice.datastructure.Graph;
import org.apache.commons.lang3.RandomStringUtils;

public class GraphUtil {

    public static Graph<String, Integer> randomGraph(boolean isDirected) {
        Graph<String, Integer> graph = new Graph<>(isDirected);
        for (int i = 0; i < 10; i++) {
            graph.addEdge(RandomStringUtils.randomNumeric(1), RandomStringUtils.randomNumeric(1));
        }
        return graph;
    }

    public static void main(String[] args) {
        final Graph<String, Integer> graph = randomGraph(true);
        System.out.println(graph);

        final String dataStartingNode = graph.getAnyVertex().data;
        System.out.println("Starting node -> " + dataStartingNode);
        System.out.println();

        // dfs with stack
        System.out.println("DFS with stack -> " + graph.dfsWithStack(dataStartingNode));
        graph.visited.clear();

        // dfs with recursion
        StringBuffer sb = new StringBuffer();
        graph.dfsWithRecursion(dataStartingNode, sb);
        System.out.println("DFS with recursion -> " + sb.toString());
        graph.visited.clear();

        // bfs with queue
        System.out.println("BFS with queue -> " + graph.bfsWithQueue(dataStartingNode));
    }
}
