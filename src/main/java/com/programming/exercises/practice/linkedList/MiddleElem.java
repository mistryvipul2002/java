package com.programming.exercises.practice.linkedList;

import com.programming.exercises.practice.datastructure.LinkedList;
import com.programming.exercises.practice.datastructure.Node;

/**
 * Find middle elem
 */
public class MiddleElem {

    public static void main(String[] args) {
        LinkedList<Integer> list = LinkedListUtil.createRandomLinkedList(null);
        System.out.println(list);

        Node<Integer> seek = null;
        final int size = list.size();
        if (size % 2 == 1) {
            seek = list.seek(size / 2);
        }
        System.out.println("Middle = " + (seek == null ? null : seek.data));
    }

}
