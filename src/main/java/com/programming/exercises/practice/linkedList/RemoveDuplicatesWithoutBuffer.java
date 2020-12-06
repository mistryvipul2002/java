package com.programming.exercises.practice.linkedList;

import com.programming.exercises.practice.datastructure.LinkedList;
import com.programming.exercises.practice.datastructure.Node;

/**
 * Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicatesWithoutBuffer {

    public static void main(String[] args) {
        LinkedList<Integer> list = LinkedListUtil.createRandomLinkedList(20);
        System.out.println(list);

        Node<Integer> curr = list.getHead();
        while (curr.next != null) {
            new LinkedList().head(curr.next).deleteNode(curr.data);
            curr = curr.next;
        }

        System.out.println(list);
    }
}
