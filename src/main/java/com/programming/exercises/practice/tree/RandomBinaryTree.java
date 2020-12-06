package com.programming.exercises.practice.tree;

import com.programming.exercises.practice.datastructure.TreeNode;
import org.apache.commons.lang3.RandomUtils;

public class RandomBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<Integer>(RandomUtils.nextInt() % 100);
        treeNode.populateRandom(treeNode, 5);

        System.out.println(treeNode);
    }
}
