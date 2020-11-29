package com.programming.exercises.practice.linkedList;

import org.apache.commons.lang3.RandomUtils;

public class Util {
    
    public static Node createRandomLinkedList(){
        Node head = new Node(RandomUtils.nextInt()%10);
        Node curr = head;
        for(int i=0;i<RandomUtils.nextInt()%20;i++){
            curr.next = new Node(RandomUtils.nextInt()%10);
            curr = curr.next;
        }
        
        return head;
    }
    
}
