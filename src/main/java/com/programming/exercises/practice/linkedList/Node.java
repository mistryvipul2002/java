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
        
        while (curr.next != null) {
            if (curr.next.data == d) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return this;
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

    public static void main(String[] args) {
        System.out.println("\nInitialize");
        Node n = null;
        System.out.println(n);

        System.out.println("\nAdd 2");
        n = new Node(2);
        System.out.println(n);

        System.out.println("\nAdd 4");
        n.next = new Node(4);
        System.out.println(n);

        System.out.println("\nAdd 6");
        n.appendToLast(6);
        System.out.println(n);

        System.out.println("\nAdd 6");
        n.appendToLast(6);
        System.out.println(n);

        System.out.println("\nAdd 6");
        n.appendToLast(6);
        System.out.println(n);

        System.out.println("\nDelete 6");
        n.deleteNode(6);
        System.out.println(n);

        System.out.println("\nDelete 4");
        n.deleteNode(4);
        System.out.println(n);

        System.out.println("\nDelete 2");
        Node newHead = n.deleteNode(2);
        System.out.println(newHead);
    }
}
