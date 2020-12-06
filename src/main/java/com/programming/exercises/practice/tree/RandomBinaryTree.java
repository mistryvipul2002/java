package com.programming.exercises.practice.tree;

import com.programming.exercises.practice.datastructure.TreeNode;
import org.apache.commons.lang3.RandomUtils;

public class RandomBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<>(RandomUtils.nextInt() % 100);
        treeNode.isBinarySearch = false;
        for (int i = 0; i < 10; i++) {
            treeNode.add(RandomUtils.nextInt() % 100);
        }
        System.out.println(treeNode);

        // Traversal the tree
        StringBuffer sb = new StringBuffer("Pre-order: ");
        treeNode.preOrder(sb);
        System.out.println(sb);

        sb = new StringBuffer("In-order: ");
        treeNode.inOrder(sb);
        System.out.println(sb);

        sb = new StringBuffer("Post-order: ");
        treeNode.postOrder(sb);
        System.out.println(sb);

        // search
        final int toFind = RandomUtils.nextInt() % 100;
        final boolean isFound = treeNode.isFound(toFind);
        System.out.println("\n" + toFind + " " + (isFound ? "" : "not") + " found");

//        if (isFound) {
//            // delete
//            treeNode.delete(toFind);
//            System.out.println("After deletion of " + toFind);
//            System.out.println(treeNode);
//        }
    }
}
