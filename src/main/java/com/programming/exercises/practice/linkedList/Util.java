package com.programming.exercises.practice.linkedList;

import org.apache.commons.lang3.RandomUtils;

public class Util {

    public static Node createRandomLinkedList(Integer size) {
        if (size == null) size = 10;
        
        if (size == 0) return null;
        
        Node head = new Node(RandomUtils.nextInt() % 10);
        if (size == 1) return head;
        
        Node curr = head;
        for (int i = 0; i < RandomUtils.nextInt() % (size-1); i++) {
            curr.next = new Node(RandomUtils.nextInt() % 10);
            curr = curr.next;
        }

        return head;
    }

}
