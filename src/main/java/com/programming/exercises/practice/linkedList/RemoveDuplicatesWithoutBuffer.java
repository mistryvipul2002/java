package com.programming.exercises.practice.linkedList;

/**
 * Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicatesWithoutBuffer {
    
    public static void main(String[] args) {
        Node head = Util.createRandomLinkedList(20);
        System.out.println(head);

        Node curr = head;
        while (curr.next != null) {
            curr.next.deleteNode(curr.data);
            curr = curr.next;
        }

        System.out.println(head);
    }
}
