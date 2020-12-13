package com.programming.exercises.practice.tree;

import com.programming.exercises.practice.datastructure.TreeNode;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class RandomBinaryTree {

    private static int totRandomNodes = 20;
    private static boolean isBinarySearchTree = true;
    private static boolean isRandom = false;
    private static int[] treeData = {87, -5, 90, 63, 82, -13, -69, 65, 72, -44, 77, 50, 8, 25, 11, -16, 62, 84, 29, 73, 16};

    public static void main(String[] args) {
        System.out.println("Is binary search tree = " + isBinarySearchTree);
        TreeNode<Integer> treeNode;
        if (isRandom) {
            treeNode = new TreeNode<>(getRandomInt(), isBinarySearchTree);
            treeNode.isBinarySearch = isBinarySearchTree;
            for (int i = 0; i < totRandomNodes; i++) {
                treeNode.add(getRandomInt());
            }
        } else {
            treeNode = new TreeNode<>(treeData[0], isBinarySearchTree);
            for (int i = 1; i < treeData.length; i++) {
                treeNode.add(treeData[i]);
            }
        }
        System.out.println(treeNode);

        // Traversal the tree
        StringBuffer sb = new StringBuffer("Pre-order (DFS): ");
        treeNode.preOrder(sb);
        System.out.println(sb);

        sb = new StringBuffer("In-order: ");
        treeNode.inOrder(sb);
        System.out.println(sb);

        sb = new StringBuffer("Post-order: ");
        treeNode.postOrder(sb);
        System.out.println(sb);

        System.out.println("Max-Depth: " + treeNode.maxHeight());
        System.out.println("Min-Depth: " + treeNode.minHeight());
        System.out.println("IsBalanced: " + treeNode.isBalanced());

        // search
        final int toFind = getRandomInt();
        final boolean isFound = treeNode.isFound(toFind);
        System.out.println("\n" + toFind + " " + (isFound ? "" : "not") + " found");

        // print linked list
        System.out.println("\nLinked lists");
        final List<List<TreeNode<Integer>>> lists = treeNode.listNodesForEachDepth();
        for (List<TreeNode<Integer>> list : lists) {
            for (TreeNode<Integer> node : list) {
                System.out.print(node.data + ",");
            }
            System.out.println();
        }

        System.out.println("\nBFS = " + treeNode.bfs());

        System.out.println();
        int sum = 82;
        System.out.println("All paths where sum from root is : ");
        treeNode.printAllPathsSum(-sum, "");

//        if (isFound) {
//            // delete
//            treeNode.delete(toFind);
//            System.out.println("After deletion of " + toFind);
//            System.out.println(treeNode);
//        }
    }

    private static int getRandomInt() {
        return RandomUtils.nextInt() % 100 * (RandomUtils.nextInt() % 2 == 1 ? -1 : 1);
    }
}
