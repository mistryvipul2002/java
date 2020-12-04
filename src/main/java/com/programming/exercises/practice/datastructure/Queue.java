package com.programming.exercises.practice.datastructure;

public class Queue<T> extends LinkedCollection {

    Node tail;

    public void enqueue(T d) {
        if (head == null) {
            head = new Node<>(d);
            tail = head;
        } else {
            Node n = new Node<>(d);
            tail.next = n;
            tail = n;
        }
    }

    public Node<T> dequeue() {
        if (head == null) {
            return null;
        } else {
            Node n = head;
            head = head.next;
            return n;
        }
    }

    public static void main(String[] args) {
        Queue<String> s = new Queue();
        System.out.println(s);

        s.enqueue("45");
        System.out.println(s);

        s.enqueue("34");
        System.out.println(s);

        s.enqueue("73");
        System.out.println(s);

        s.dequeue();
        System.out.println(s);

        s.dequeue();
        System.out.println(s);

        s.dequeue();
        System.out.println(s);
    }

}
