package com.programming.exercises.practice.datastructure;

public class LinkedList<T extends Comparable<T>> extends LinkedCollection<T> {

    public Node<T> getHead(){
        return head;
    }

    public LinkedList<T> head(Node<T> head) {
        this.head = head;
        return this;
    }

    public static void main(String[] args) {
        System.out.println("\nInitialize");
        LinkedList list = new LinkedList<Integer>();
        System.out.println(list);

        System.out.println("\nAdd 2");
        list.head = new Node(2);
        System.out.println(list);

        System.out.println("\nAdd 4");
        list.add(4);
        System.out.println(list);
        System.out.println("Size = " + list.size());

        System.out.println("\nAdd 6");
        list.add(6);
        System.out.println(list);

        System.out.println("\nAdd 8");
        list.add(8);
        System.out.println(list);

        System.out.println("\nAdd 9");
        list.add(9);
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
