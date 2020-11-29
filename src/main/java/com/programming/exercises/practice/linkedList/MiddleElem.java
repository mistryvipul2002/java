package com.programming.exercises.practice.linkedList;

/**
 * Find middle elem
 */
public class MiddleElem {

    public static void main(String[] args) {
        Node head = Util.createRandomLinkedList(null);
        System.out.println(head);

        Node seek = null;
        final int size = head.size();
        if (size % 2 == 1) {
            seek = head.seek(size / 2);
        }
        System.out.println("Middle = " + (seek == null ? null : seek.data));
    }

}
