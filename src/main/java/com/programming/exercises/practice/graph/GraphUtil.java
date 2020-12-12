package com.programming.exercises.practice.graph;

import com.programming.exercises.practice.datastructure.Graph;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Validate;

public class GraphUtil {

    public static Graph<String, Integer> randomGraph(boolean isDirected) {
        Graph<String, Integer> graph = new Graph<>(isDirected);
        for (int i = 0; i < 10; i++) {
            graph.addEdge(RandomStringUtils.randomNumeric(1), RandomStringUtils.randomNumeric(1));
        }
        return graph;
    }

    public static void main(String[] args) {
        final Graph<String, Integer> graph = randomGraph(false);
        System.out.println(graph);

        final String dataStartingNode = RandomStringUtils.randomNumeric(1);
        System.out.println("Starting node -> " + dataStartingNode);
        System.out.println();

        Validate.isTrue(graph.isVertex(dataStartingNode));

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

        System.out.println();
        final String source = RandomStringUtils.randomNumeric(1);
        final String dest = RandomStringUtils.randomNumeric(1);
        System.out.println("Route exists from " + source + " to " + dest + " ? ");
        System.out.println(graph.isRouteExist(source, dest));
    }
}
