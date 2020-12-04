package com.programming.exercises.practice.datastructure;

public class Stack<T> extends LinkedCollection {

    public Node<T> pop() {
        if (head == null)
            return null;

        Node popped = head.next;
        head = head.next;
        return popped;
    }

    public void push(T data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Stack: ");

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

    public static void main(String[] args) {
        Stack<String> s = new Stack();
        System.out.println(s);

        s.push("45");
        System.out.println(s);

        s.push("34");
        System.out.println(s);

        s.push("73");
        System.out.println(s);

        s.pop();
        System.out.println(s);
    }

}
