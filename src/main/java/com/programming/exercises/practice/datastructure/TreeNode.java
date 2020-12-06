package com.programming.exercises.practice.datastructure;

import org.apache.commons.lang3.RandomUtils;

public class TreeNode<T extends Comparable<T>> {
    public T data;
    public TreeNode<T> left, right;

    public TreeNode(T d) {
        this.data = d;
    }

    public void addSorted(T data) {
        if (data.compareTo(this.data) >= 0) {
            if (right == null) {
                right = new TreeNode<T>(data);
            } else {
                right.addSorted(data);
            }
        } else {
            if (left == null) {
                left = new TreeNode<T>(data);
            } else {
                left.addSorted(data);
            }
        }
    }

    public void populateRandom(TreeNode<Integer> node, int levels) {
        if (levels == 0) return;

        int numChildren = RandomUtils.nextInt() % 3;
        if (numChildren == 0) return;
        if (numChildren == 1) {
            boolean isLeft = RandomUtils.nextInt() % 2 == 0;
            if (isLeft) {
                node.left = new TreeNode<>(RandomUtils.nextInt() % 100);
                populateRandom(node.left, levels - 1);
            } else {
                node.right = new TreeNode<>(RandomUtils.nextInt() % 100);
                populateRandom(node.right, levels - 1);
            }
        }
        if (numChildren == 2) {
            node.left = new TreeNode<>(RandomUtils.nextInt() % 100);
            populateRandom(node.left, levels - 1);

            node.right = new TreeNode<>(RandomUtils.nextInt() % 100);
            populateRandom(node.right, levels - 1);
        }
    }

    public void inOrder(StringBuffer sb) {
        if (left != null) left.inOrder(sb);
        sb.append(data + ", ");
        if (right != null) right.inOrder(sb);
    }

    public void preOrder(StringBuffer sb) {
        sb.append(data + ", ");
        if (left != null) left.preOrder(sb);
        if (right != null) right.preOrder(sb);
    }

    public void postOrder(StringBuffer sb) {
        if (left != null) left.postOrder(sb);
        if (right != null) right.postOrder(sb);
        sb.append(data + ", ");
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        print("", this, false, sb);
        return sb.toString();
    }

    public void print(String prefix, TreeNode node, boolean isLeft, StringBuffer sb) {
        if (node != null) {
            sb.append(prefix + (isLeft ? "L- " : "R- ") + node.data + "\n");
            print(prefix + (isLeft ? "|   " : "    "), node.left, true, sb);
            print(prefix + (isLeft ? "|   " : "    "), node.right, false, sb);
        }
    }
}
