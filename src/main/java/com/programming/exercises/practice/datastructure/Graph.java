package com.programming.exercises.practice.datastructure;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T extends Comparable<T>, W extends Comparable<W>> {
    private final Map<T, Vertex<T, W>> vertexMap = new HashMap<>();
    public Set<Vertex<T, W>> visited = new HashSet<>();
    private final Map<Vertex<T, W>, Set<Vertex<T, W>>> graphMap = new HashMap<>();
    public boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public Vertex<T, W> getAnyVertex() {
        return vertexMap.entrySet().stream().findAny().get().getValue();
    }

    public boolean isVertex(T data) {
        return vertexMap.containsKey(data);
    }

    private Vertex<T, W> getVertex(T data) {
        if (!vertexMap.containsKey(data)) {
            vertexMap.put(data, new Vertex<>(data));
        }
        return vertexMap.get(data);
    }

    public void addEdge(T source, T dest) {
        Validate.notNull(source);
        Validate.notNull(dest);
        if (source.compareTo(dest) == 0) return;
        final Vertex<T, W> sourceVertex = getVertex(source);
        final Vertex<T, W> destVertex = getVertex(dest);

        if (!graphMap.containsKey(sourceVertex)) {
            graphMap.put(sourceVertex, new HashSet<>());
        }
        graphMap.get(sourceVertex).add(destVertex);

        if (!isDirected) {
            if (!graphMap.containsKey(destVertex)) {
                graphMap.put(destVertex, new HashSet<>());
            }
            graphMap.get(destVertex).add(sourceVertex);
        }
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

        StringBuilder sb = new StringBuilder();

        Stack<Vertex<T, W>> stack = new Stack<>();
        stack.push(dataVertex);

        while (!stack.isEmpty()) {
            final Vertex<T, W> popped = stack.pop();
            if (visited.contains(popped)) continue;

            visited.add(popped);
            sb.append(popped.data).append(",");

            if (graphMap.containsKey(popped)) {
                // replace it with connected nodes
                for (Vertex<T, W> connectedVertex : graphMap.get(popped)) {
                    if (visited.contains(connectedVertex)) continue;
                    stack.push(connectedVertex);
                }
            }
        }

        visited.clear();
        return sb.toString();
    }

    public void dfsWithRecursion(T data, StringBuffer sb) {
        final Vertex<T, W> dataVertex = getVertex(data);
        visited.add(dataVertex);
        sb.append(data).append(",");

        if (graphMap.containsKey(dataVertex)) {
            for (Vertex<T, W> connectedVertex : graphMap.get(dataVertex)) {
                if (!visited.contains(connectedVertex)) {
                    dfsWithRecursion(connectedVertex.data, sb);
                }
            }
        }
    }

    public String bfsWithQueue(T data) {
        StringBuilder sb = new StringBuilder();
        final Vertex<T, W> dataVertex = getVertex(data);
        if (dataVertex == null) return null;

        Queue<Vertex<T, W>> queue = new Queue<>();
        queue.enqueue(dataVertex);
        visited.add(dataVertex);
        sb.append(dataVertex.data).append(",");

        while (!queue.isEmpty()) {
            final Vertex<T, W> popped = queue.dequeue().data;

            if (graphMap.containsKey(popped)) {
                // replace it with connected nodes
                for (Vertex<T, W> connectedVertex : graphMap.get(popped)) {
                    if (visited.contains(connectedVertex)) continue;

                    queue.enqueue(connectedVertex);
                    visited.add(connectedVertex);
                    sb.append(connectedVertex.data).append(",");
                }
            }
        }

        visited.clear();
        return sb.toString();
    }

    public boolean isRouteExist(T source, T dest) {
        if (source.equals(dest)) throw new RuntimeException("Same source and dest!");

        Validate.notNull(source);
        Validate.isTrue(isVertex(source), source + " not a vertex");
        final Vertex<T, W> sourceVertex = getVertex(source);
        visited.add(sourceVertex);

        Validate.notNull(dest);
        Validate.isTrue(isVertex(dest), dest + " not a vertex");
        final Vertex<T, W> destVertex = getVertex(dest);
        Validate.notNull(destVertex);

        return isRouteExist(sourceVertex, destVertex, "");
    }

    private boolean isRouteExist(Vertex<T, W> sourceVertex, Vertex<T, W> destVertex, String route) {
        route += sourceVertex.data + "->";
        visited.add(sourceVertex);
        if (graphMap.containsKey(sourceVertex)) {
            // replace it with connected nodes
            for (Vertex<T, W> connectedVertex : graphMap.get(sourceVertex)) {
                if (visited.contains(connectedVertex)) continue;

                if (connectedVertex.equals(destVertex)) {
                    route += connectedVertex.data;
                    System.out.println(route);
                    return true;
                }

                if (isRouteExist(connectedVertex, destVertex, route)) return true;
            }
        }

        return false;
    }

    public boolean isCycle() {
        for (T data : vertexMap.keySet()) {
            final Vertex<T, W> vertex = getVertex(data);
            if (visited.contains(vertex)) continue;
            visited.add(vertex);

            final boolean isCycle = isCycle(vertex, new ArrayList<>() {{
                add(vertex);
            }});
            if (isCycle) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(Vertex<T, W> sourceVertex, List<Vertex<T, W>> parents) {
        if (graphMap.containsKey(sourceVertex)) {
            for (Vertex<T, W> connectedVertex : graphMap.get(sourceVertex)) {
                if (parents.contains(connectedVertex)) {
                    if (!isDirected && parents.get(parents.size() - 2).equals(connectedVertex)) {
                        continue;
                    }

                    // cycle exists
                    parents.add(connectedVertex);
                    System.out.println(parents);
                    return true;
                }

                if (visited.contains(connectedVertex)) {
                    continue;
                }
                visited.add(connectedVertex);

                final boolean cycle = isCycle(connectedVertex, new ArrayList<>() {{
                    addAll(parents);
                    add(connectedVertex);
                }});
                if (cycle) {
                    return true;
                }
            }
        }
        return false;
    }

}
