package com.programming.exercises.practice.linkedList;

public class Test {
    public static void main(String[] args) {
        Node n = null;
        System.out.println(n);
        
        n = new Node(2);
        System.out.println(n);
        
        n.next = new Node(4);
        System.out.println(n);
        
        n.appendToLast(6);
        System.out.println(n);

        n.appendToLast(6);
        System.out.println(n);

        n.appendToLast(6);
        System.out.println(n);
        
        n.deleteNode(6);
        System.out.println(n);
        
        n.deleteNode(4);
        System.out.println(n);

        Node newHead = n.deleteNode(2);
        System.out.println(newHead);
    }
}
