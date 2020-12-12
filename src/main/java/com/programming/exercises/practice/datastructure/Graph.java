package com.programming.exercises.practice.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T extends Comparable<T>, W extends Comparable<W>> {
    private Map<T, Vertex<T, W>> vertexMap = new HashMap<>();
    private Map<Vertex<T, W>, Boolean> visited = new HashMap<>();
    private Map<Vertex<T, W>, Set<Vertex<T, W>>> graphMap = new HashMap<>();
    public boolean isDirected = false;

    public Vertex<T, W> getAnyVertex() {
        return vertexMap.entrySet().stream().findAny().get().getValue();
    }

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

    public String dfsWithStack(T data) {
        final Vertex<T, W> dataVertex = getVertex(data);
        if (dataVertex == null) return null;

        StringBuffer sb = new StringBuffer();

        Stack<Vertex<T, W>> stack = new Stack<>();
        stack.push(dataVertex);

        while (!stack.isEmpty()) {
            final Vertex<T, W> popped = stack.pop();
            if (visited.containsKey(popped)) continue;

            visited.put(popped, true);
            sb.append(popped.data + ",");

            if (graphMap.containsKey(popped)) {
                // replace it with connected nodes
                for (Vertex<T, W> connectedVertex : graphMap.get(popped)) {
                    if (visited.containsKey(connectedVertex)) continue;
                    stack.push(connectedVertex);
                }
            }
        }

        visited.clear();
        return sb.toString();
    }

    public void dfsWithRecursion(T data, StringBuffer sb) {
        final Vertex<T, W> dataVertex = getVertex(data);
        if (dataVertex == null || visited.containsKey(dataVertex)) return;

        if (graphMap.containsKey(dataVertex)) {
            for (Vertex<T, W> connectedVertex : graphMap.get(dataVertex)) {
                if (!visited.containsKey(connectedVertex)) {
                    visited.put(dataVertex, true);
                    sb.append(connectedVertex.data + ",");
                    dfsWithRecursion(connectedVertex.data, sb);
                }
            }
        }
    }

}
