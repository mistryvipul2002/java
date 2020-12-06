package com.programming.exercises.practice.linkedList;

import com.programming.exercises.practice.datastructure.LinkedList;
import com.programming.exercises.practice.datastructure.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedList<Integer> list = LinkedListUtil.createRandomLinkedList(20);
        System.out.println(list);

        Node<Integer> head = list.getHead();
        if (head.next != null) {
            Node<Integer> prev = head;
            Set<Integer> existing = new HashSet<>();
            existing.add(head.data);
            Node<Integer> curr = head.next;

            do {
                if (existing.contains(curr.data)) {
                    prev.next = curr.next;
                } else {
                    existing.add(curr.data);
                    prev = curr;
                }
                curr = curr.next;
            } while (curr != null);
        }

        System.out.println(list);
    }
}
