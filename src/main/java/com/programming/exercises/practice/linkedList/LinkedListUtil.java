package com.programming.exercises.practice.linkedList;

import com.programming.exercises.practice.datastructure.LinkedList;
import com.programming.exercises.practice.datastructure.Node;
import org.apache.commons.lang3.RandomUtils;

public class LinkedListUtil {
    public static LinkedList<Integer> createRandomLinkedList(Integer minSize) {
        if (minSize == null) minSize = 10;
        if (minSize == 0) return null;

        final LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(RandomUtils.nextInt() % 10);
        if (minSize > 0) {

            for (int i = 0; i < RandomUtils.nextInt() % minSize; i++) {
                integerLinkedList.add(RandomUtils.nextInt() % 10);
            }
        }

        return integerLinkedList;
    }

}
