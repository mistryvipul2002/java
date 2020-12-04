package com.programming.exercises.practice.linkedList;

import com.programming.exercises.practice.linkedList.datastructure.LinkedList;
import com.programming.exercises.practice.linkedList.datastructure.Node;

/**
 * Find middle elem
 */
public class MiddleElem {

    public static void main(String[] args) {
        LinkedList<Integer> list = Util.createRandomLinkedList(null);
        System.out.println(list);

        Node seek = null;
        final int size = list.size();
        if (size % 2 == 1) {
            seek = list.seek(size / 2);
        }
        System.out.println("Middle = " + (seek == null ? null : seek.data));
    }

}
