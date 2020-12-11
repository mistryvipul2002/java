package com.programming.exercises.practice.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T extends Comparable<T>, W extends Comparable<T>> {
    private Map<T, Vertex<T, W>> vertexMap = new HashMap<>();
    private Map<Vertex<T, W>, Set<Vertex<T, W>>> graphMap = new HashMap<>();
    public boolean isDirected = false;

    public void edge(T source, T dest) {
        if (source.compareTo(dest) == 0) return;

        final Vertex<T, W> sourceVertex = getVertex(source);
        if (!graphMap.containsKey(sourceVertex)) {
            graphMap.put(sourceVertex, new HashSet<>());
        }
        graphMap.get(sourceVertex).add(getVertex(dest));

        if (!isDirected) {
            final Vertex<T, W> destVertex = getVertex(dest);
            if (!graphMap.containsKey(destVertex)) {
                graphMap.put(destVertex, new HashSet<>());
            }
            graphMap.get(destVertex).add(getVertex(source));
        }
    }

    private Vertex<T, W> getVertex(T data) {
        if (!vertexMap.containsKey(data)) {
            vertexMap.put(data, new Vertex<>(data));
        }
        return vertexMap.get(data);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "map=" + graphMap +
                '}';
    }

    public void dfs(T data) {
        final Vertex<T, W> dataVertex = getVertex(data);
        if (dataVertex == null) return;

        Stack<Vertex<T, W>> stack = new Stack<>();
        stack.push(dataVertex);

        while (!stack.isEmpty()) {
            final Vertex<T, W> popped = stack.pop();
            if (popped.state == State.VISITED) continue;
            
            popped.state = State.VISITED;
            System.out.println(popped);

            if (graphMap.containsKey(popped)) {
                // replace it with connected nodes
                for (Vertex<T, W> connectedVertex : graphMap.get(popped)) {
                    if (connectedVertex.state == State.VISITED) continue;
                    stack.push(connectedVertex);
                }
            }
        }
    }

}
