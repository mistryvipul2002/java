package com.programming.exercises.practice.graph;

import com.programming.exercises.practice.datastructure.Graph;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Validate;

public class GraphUtil {

    private static boolean isDirected = true;
    private static boolean isRandom = true;
    private static String input = "2=[4], 3=[9], 4=[2, 3], 5=[9], 7=[3], 8=[3, 9], 9=[8]";

    public static Graph<String, Integer> randomGraph() {
        Graph<String, Integer> graph = new Graph<>(isDirected);
        if (isRandom) {
            for (int i = 0; i < 10; i++) {
                graph.addEdge(RandomStringUtils.randomNumeric(1), RandomStringUtils.randomNumeric(1));
            }
        } else {
            String source = null;
            String dest = null;
            boolean destStart = false, sourceStart = true;
            for (int i = 0; i < input.length(); i++) {
                final char c = input.charAt(i);
                if (c == ',' || c == '=' || c == ' ') {
                    continue;
                }
                if (c == '[') {
                    sourceStart = false;
                    destStart = true;
                    continue;
                }
                if (c == ']') {
                    destStart = false;
                    sourceStart = true;
                    continue;
                }

                if (sourceStart) {
                    source = c + "";
                    continue;
                }

                if (destStart) {
                    dest = c + "";
                }

                graph.addEdge(source, dest);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        final Graph<String, Integer> graph = randomGraph();
        System.out.println(graph);

        final String dataStartingNode = RandomStringUtils.randomNumeric(1);
        System.out.println("Starting node -> " + dataStartingNode);
        System.out.println();

        Validate.isTrue(graph.isVertex(dataStartingNode), dataStartingNode + " not a vertex!");

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

        try {
            // is Route exists?
            System.out.println();
            final String source = RandomStringUtils.randomNumeric(1);
            final String dest = RandomStringUtils.randomNumeric(1);
            System.out.println("Route exists from " + source + " to " + dest + " ? ");
            System.out.println(graph.isRouteExist(source, dest));
        } catch (Exception e) {
            e.printStackTrace();
        }


        // is cycle exists
        graph.visited.clear();
        System.out.println();
        System.out.println("Is cycle exist?");
        final boolean isCycle = graph.isCycle();
        System.out.println(isCycle);
    }
}
