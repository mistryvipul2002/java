package com.programming.exercises.practice.datastructure;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertex<T extends Comparable<T>, W extends Comparable<W>> implements Comparable<Vertex<T, W>> {
    public T data;
    public W weight;

    public Vertex(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public int compareTo(Vertex<T, W> v) {
        return this.data.compareTo(v.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.data.equals(((Vertex) o).data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public static void main(String[] args) {
        final Vertex<Integer, Integer> v1 = new Vertex<>(23);
        final Vertex<Integer, Integer> v2 = new Vertex<>(45);
        System.out.println(v1.compareTo(v2));
        System.out.println(v1.equals(v2));

        Set<Vertex<Integer, Integer>> set = new HashSet<>();
        set.add(v1);
        set.add(v2);
        System.out.println(set);

    }
}
