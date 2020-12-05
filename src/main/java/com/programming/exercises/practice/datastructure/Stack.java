package com.programming.exercises.practice.datastructure;

import org.apache.commons.lang3.RandomUtils;

public class Stack<T extends Comparable<T>> extends LinkedCollection<T> {

    public T pop() {
        if (head == null)
            return null;

        Node<T> popped = head;
        head = head.next;
        return popped.data;
    }

    public void push(T data) {
        super.add(data);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        System.out.println(s);

        s.push(RandomUtils.nextInt() % 100);
        System.out.println(s);

        s.push(RandomUtils.nextInt() % 100);
        System.out.println(s);

        s.push(RandomUtils.nextInt() % 100);
        System.out.println(s);

        s.push(RandomUtils.nextInt() % 100);
        System.out.println(s);

        s.push(RandomUtils.nextInt() % 100);
        System.out.println(s);

        s.push(RandomUtils.nextInt() % 100);
        System.out.println(s);

        s.push(RandomUtils.nextInt() % 100);
        System.out.println(s);

        s.pop();
        System.out.println(s);

        System.out.println(s.min());
    }

}
