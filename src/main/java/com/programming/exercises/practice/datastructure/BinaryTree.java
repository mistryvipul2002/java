package com.programming.exercises.practice.datastructure;

public class BinaryTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public BinaryTree<T> root(T data) {
        this.root = new TreeNode<T>(data);
        return this;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
