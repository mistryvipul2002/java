package com.programming.exercises.practice.graph;

import com.programming.exercises.practice.datastructure.Graph;
import org.apache.commons.lang3.RandomUtils;

public class GraphUtil {

    public static Graph<Integer, Integer> randomDirectedGraph() {
        Graph<Integer, Integer> graph = new Graph<>();
        graph.isDirected = true;
        for (int i = 0; i < 10; i++) {
            graph.edge(1 + RandomUtils.nextInt() % 5, 1 + RandomUtils.nextInt() % 5);
        }

        return graph;
    }

    public static void main(String[] args) {
        final Graph<Integer, Integer> graph = randomDirectedGraph();
        System.out.println(graph);
        graph.dfs(1 + RandomUtils.nextInt() % 5);
    }
}
