package com.programming.exercises.practice.linkedList;

public class Node {
    int data;
    Node next;

    public Node(int d) {
        this.data = d;
    }

    public void appendToLast(int d) {
        seekLast().next = new Node(d);
    }

    public Node deleteNode(int d) {
        Node curr = this;
        if (curr.data == d) {
            return curr.next;
        }
        
        while (curr != null) {
            if (curr.next != null && curr.next.data == d) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return curr;
    }

    public Node seekLast() {
        Node curr = this;
        while (curr.next != null) curr = curr.next;
        return curr;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node curr = this;
        while (curr != null) {
            sb.append(curr.data);

            // little hack
            if (curr.next != null)
                sb.append("->");

            // move to next
            curr = curr.next;
        }
        return sb.toString();
    }
}
