package com.programming.exercises.practice.linkedList.datastructure;

public class LinkedList<T> {
    public Node<T> head;

    public LinkedList(Node head) {
        this.head = head;
    }

    @Override
    public String toString() {
        if (head == null) return null;

        StringBuffer sb = new StringBuffer();
        Node curr = head;
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

    public void appendToLast(T d) {
        if (size() == 0) head = new Node<>(d);
        else seekLast().next = new Node(d);
    }

    public void deleteNode(T d) {
        if (head.data == d) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == d) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
    }

    public Node seekLast() {
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        return curr;
    }

    public Node seek(int n) {
        Node curr = head;
        int count = 0;
        do {
            if (count++ == n) {
                return curr;
            }
            curr = curr.next;
        } while (curr != null);
        return null;
    }

    public int size() {
        if (head == null) return 0;
        
        int count = 1;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("\nInitialize");
        LinkedList list = new LinkedList<Integer>(null);
        System.out.println(list);

        System.out.println("\nAdd 2");
        list.head = new Node(2);
        System.out.println(list);

        System.out.println("\nAdd 4");
        list.head.next = new Node(4);
        System.out.println(list);
        System.out.println("Size = " + list.size());

        System.out.println("\nAdd 6");
        list.appendToLast(6);
        System.out.println(list);

        System.out.println("\nAdd 8");
        list.appendToLast(8);
        System.out.println(list);

        System.out.println("\nAdd 9");
        list.appendToLast(9);
        System.out.println(list);
        System.out.println("Size = " + list.size());
        for (int i = 0; i < 7; i++) {
            final Node seek = list.seek(i);
            System.out.println("Seek " + i + " = " + (seek == null ? null : seek.data));
        }

        System.out.println("\nDelete 6");
        list.deleteNode(6);
        System.out.println(list);

        System.out.println("\nDelete 4");
        list.deleteNode(4);
        System.out.println(list);

        System.out.println("\nDelete 2");
        list.deleteNode(2);
        System.out.println(list);
    }
}
