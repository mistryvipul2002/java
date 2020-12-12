package com.programming.exercises.practice.graph;

import com.programming.exercises.practice.datastructure.Graph;
import com.programming.exercises.practice.datastructure.Vertex;
import org.apache.commons.lang3.RandomStringUtils;

public class GraphUtil {

    public static Graph<String, Integer> randomDirectedGraph() {
        Graph<String, Integer> graph = new Graph<>();
        graph.isDirected = true;
        for (int i = 0; i < 10; i++) {
            graph.edge(RandomStringUtils.randomNumeric(1), RandomStringUtils.randomNumeric(1));
        }

        return graph;
    }

    public static void main(String[] args) {
        final Graph<String, Integer> graph = randomDirectedGraph();
        System.out.println(graph);

        // dfs with stack
        final Vertex<String, Integer> anyVertex = graph.getAnyVertex();
        System.out.println(graph.dfsWithStack(anyVertex.data));

        // dfs with recursion
        StringBuffer sb = new StringBuffer(anyVertex.data + ",");
        graph.dfsWithRecursion(anyVertex.data, sb);
        System.out.println(sb.toString());
    }
}
