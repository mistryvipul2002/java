package com.programming.exercises.practice.datastructure;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode<T extends Comparable<T>> {
    public boolean isBinarySearch = true;
    public T data;
    public TreeNode<T> left, right;

    public TreeNode(T d) {
        this.data = d;
    }

    public void add(T data) {
        if (isBinarySearch) {
            addSorted(data);
        } else {
            addRandom(this, data);
        }
    }

    private void addSorted(T data) {
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

    private void addRandom(TreeNode<T> node, T data) {
        if (RandomUtils.nextInt() % 2 == 0) {
            // go left
            if (node.left == null) {
                node.left = new TreeNode<>(data);
                node.left.isBinarySearch = false;
            } else {
                addRandom(node.left, data);
            }
        } else {
            // go right
            if (node.right == null) {
                node.right = new TreeNode<>(data);
                node.right.isBinarySearch = false;
            } else {
                addRandom(node.right, data);
            }
        }
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasSingleChild() {
        return (left == null && right != null) || (left != null && right == null);
    }

    public TreeNode<T> getSingleChild() {
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

    public TreeNode<T> getAnyLeafChild() {
        if (isLeaf()) return null;

        if (left != null) {
            return left.isLeaf() ? left : left.getAnyLeafChild();
        }

        if (right != null) {
            return right.isLeaf() ? right : right.getAnyLeafChild();
        }

        return null;
    }

    public boolean hasBothChildren() {
        return left != null && right != null;
    }

    public boolean isFound(T data) {
        if (isBinarySearch) {
            if (data.compareTo(this.data) == 0) {
                return true;
            } else {
                if (data.compareTo(this.data) < 0) {
                    return left == null ? false : left.isFound(data);
                } else {
                    return right == null ? false : right.isFound(data);
                }
            }
        } else {
            if (data.compareTo(this.data) == 0) {
                return true;
            } else {
                if (left != null && left.isFound(data)) return true;
                if (right != null && right.isFound(data)) return true;
                return false;
            }
        }
    }

    public int maxHeight() {
        if (isLeaf()) return 1;
        return 1 + Math.max(left == null ? 0 : left.maxHeight(), right == null ? 0 : right.maxHeight());
    }

    public int minHeight() {
        if (isLeaf()) return 1;
        return 1 + Math.min(left == null ? 0 : left.minHeight(), right == null ? 0 : right.minHeight());
    }

    /**
     * A balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
     */
    public boolean isBalanced() {
        return maxHeight() - minHeight() <= 1;
    }

    /**
     * Breadth First Search (BFS)
     */
    public String bfs() {
        Queue<TreeNode<T>> queue = new Queue<>();
        queue.enqueue(this);

        StringBuffer sb = new StringBuffer();
        do {
            final TreeNode<T> tempNode = queue.dequeue().data;
            sb.append(tempNode.data + ",");
            if (tempNode.left != null) queue.enqueue(tempNode.left);
            if (tempNode.right != null) queue.enqueue(tempNode.right);
        } while (!queue.isEmpty());

        return sb.toString();
    }

    /**
     * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists).
     */
    public List<List<TreeNode<T>>> listNodesForEachDepth() {
        List<List<TreeNode<T>>> lists = new ArrayList<>();
        lists.add(Arrays.asList(this));

        List<TreeNode<T>> tempList;

        do {
            tempList = lists.get(lists.size() - 1);

            final List<TreeNode<T>> list = new ArrayList<>();

            for (TreeNode<T> tempNode : tempList) {
                if (tempNode.left != null) list.add(tempNode.left);
                if (tempNode.right != null) list.add(tempNode.right);
            }

            if (list.isEmpty()) break;
            else lists.add(list);
        } while (!tempList.isEmpty());

        return lists;
    }


//    public TreeNode<T> delete(T d) {
//        if (isBinarySearch) {
//            if (d.compareTo(data) == 0) {
//
//            } else {
//                if (d.compareTo(data) < 0) {
//                    if (left != null) left.delete(d);
//                } else {
//                    if (right != null) right.delete(d);
//                }
//            }
//        } else {
//            if (d.compareTo(data) == 0) {
//                return null;
//            }
//
//            if (d.compareTo(left.data) == 0) {
//                if (left.hasNoChild()) {
//                    left = null;
//                    return this;
//                }
//                if (left.hasSingleChild()) {
//                    left = left.getSingleChild();
//                    return this;
//                }
//                if (left.hasBothChildren()) {
//                    left = left.getSingleChild();
//                    return this;
//                }
//
//            }
//        }
//    }

//    public void populateRandom(TreeNode<Integer> node, int levels) {
//        if (levels == 0) return;
//
//        int numChildren = RandomUtils.nextInt() % 3;
//        if (numChildren == 0) return;
//        if (numChildren == 1) {
//            boolean isLeft = RandomUtils.nextInt() % 2 == 0;
//            if (isLeft) {
//                node.left = new TreeNode<>(RandomUtils.nextInt() % 100);
//                populateRandom(node.left, levels - 1);
//            } else {
//                node.right = new TreeNode<>(RandomUtils.nextInt() % 100);
//                populateRandom(node.right, levels - 1);
//            }
//        }
//        if (numChildren == 2) {
//            node.left = new TreeNode<>(RandomUtils.nextInt() % 100);
//            populateRandom(node.left, levels - 1);
//
//            node.right = new TreeNode<>(RandomUtils.nextInt() % 100);
//            populateRandom(node.right, levels - 1);
//        }
//    }

    // LDR (left-data-right)
    public void inOrder(StringBuffer sb) {
        if (left != null) left.inOrder(sb);
        sb.append(data + ", ");
        if (right != null) right.inOrder(sb);
    }

    // DLR
    public void preOrder(StringBuffer sb) {
        sb.append(data + ", ");
        if (left != null) left.preOrder(sb);
        if (right != null) right.preOrder(sb);
    }

    //LRD
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
