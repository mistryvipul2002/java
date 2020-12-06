package com.programming.exercises.practice.tree;

import com.programming.exercises.practice.datastructure.TreeNode;
import org.apache.commons.lang3.RandomUtils;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<Integer>(RandomUtils.nextInt() % 100);
        for (int i = 0; i < 10; i++) {
            treeNode.addBalanced(RandomUtils.nextInt() % 100);
        }

        System.out.println(treeNode);
    }
}
