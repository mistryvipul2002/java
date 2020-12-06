package com.programming.exercises.practice.tree;

import com.programming.exercises.practice.datastructure.BinaryTree;
import org.apache.commons.lang3.RandomUtils;

public class RandomBinaryTree {

    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<Integer>().root(RandomUtils.nextInt() % 100);
        integerBinaryTree.root.populateRandom(integerBinaryTree.root, 5);

        System.out.println(integerBinaryTree);
    }
}
