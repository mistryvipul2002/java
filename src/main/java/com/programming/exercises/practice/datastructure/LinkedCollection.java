package com.programming.exercises.practice.datastructure;

public abstract class LinkedCollection<T extends Comparable<T>> {

    protected Node<T> head;

    public void add(T d) {
        final Node<T> t = new Node<>(d);
        t.next = head;
        head = t;
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

    public Node seekLast() {
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        return curr;
    }

    public void appendToLast(T d) {
        if (size() == 0) head = new Node<>(d);
        else seekLast().next = new Node(d);
    }

    /**
     * Delete the first occurrence of data d
     */
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

    public T min() {
        if (head == null)
            return null;

        T min = null;
        Node<T> curr = head;
        while (curr.next != null) {
            if (min == null) min = curr.data;
            if (curr.data.compareTo(min) < 0)
                min = curr.data;

            curr = curr.next;
        }
        return min;
    }

    public boolean isEmpty() {
        return head == null;
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(this.getClass().getSimpleName() + ": ");

        if (head != null) {
            Node curr = head;
            while (curr != null) {
                sb.append(curr.data);

                // little hack
                if (curr.next != null)
                    sb.append("->");

                // move to next
                curr = curr.next;
            }
        }
        return sb.toString();
    }

}
