package com.programming.exercises.practice.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head = Util.createRandomLinkedList();
        System.out.println(head);

        if (head.next != null) {
            Node prev = head;
            Set<Integer> existing = new HashSet<>();
            existing.add(head.data);
            Node curr = head.next;

            do {
                if (existing.contains(curr.data)) {
                    prev.next = curr.next;
                    curr = curr.next;
                } else {
                    existing.add(curr.data);
                    prev = curr;
                    curr = curr.next;
                }
            } while (curr != null);
        }

        System.out.println(head);
    }
}
