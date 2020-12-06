package com.programming.exercises.practice.tree;

import com.programming.exercises.practice.datastructure.BinaryTree;
import org.apache.commons.lang3.RandomUtils;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>().root(RandomUtils.nextInt() % 100);
        for (int i = 0; i < 10; i++) {
            binaryTree.root.addBalanced(RandomUtils.nextInt() % 100);
        }

        System.out.println(binaryTree);
    }
}
