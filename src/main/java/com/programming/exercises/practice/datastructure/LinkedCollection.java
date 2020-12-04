package com.programming.exercises.practice.datastructure;

public abstract class LinkedCollection<T> {
    
    protected Node<T> head;

    public void add(T d) {
        final Node<T> t = new Node<>(d);
        t.next = head;
        head = t;
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
