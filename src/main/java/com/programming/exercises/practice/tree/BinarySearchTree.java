package com.programming.exercises.practice.tree;

import com.programming.exercises.practice.datastructure.TreeNode;
import org.apache.commons.lang3.RandomUtils;

public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<>(RandomUtils.nextInt() % 100);
        for (int i = 0; i < 100; i++) {
            treeNode.add(RandomUtils.nextInt() % 100);
        }
        System.out.println(treeNode);

        // sort the tree
        StringBuffer sb = new StringBuffer("Sorted: ");
        treeNode.inOrder(sb);
        System.out.println(sb);

        // search
        final int toFind = RandomUtils.nextInt() % 100;
        final boolean isFound = treeNode.isFound(toFind);
        System.out.println("\n" + toFind + " " + (isFound ? "" : "not") + " found");
    }
}
