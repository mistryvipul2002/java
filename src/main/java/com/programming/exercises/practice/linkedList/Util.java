package com.programming.exercises.practice.linkedList;

import com.programming.exercises.practice.linkedList.datastructure.LinkedList;
import com.programming.exercises.practice.linkedList.datastructure.Node;
import org.apache.commons.lang3.RandomUtils;

public class Util {
    public static LinkedList<Integer> createRandomLinkedList(Integer minSize) {
        if (minSize == null) minSize = 10;
        if (minSize == 0) return null;

        Node<Integer> head = new Node(RandomUtils.nextInt() % 10);
        if (minSize > 0) {

            Node<Integer> curr = head;
            for (int i = 0; i < RandomUtils.nextInt() % minSize; i++) {
                curr.next = new Node(RandomUtils.nextInt() % 10);
                curr = curr.next;
            }
        }

        return new LinkedList<>(head);
    }

}
