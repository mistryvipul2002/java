package com.programming.exercises.practice.datastructure;

import org.apache.commons.lang3.RandomUtils;

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

    public boolean hasNoChild() {
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
