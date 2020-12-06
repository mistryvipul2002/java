package com.programming.exercises.practice.stack;

import com.programming.exercises.practice.datastructure.Stack;

public class Hanoi {
    private static final int tot = 10;

    public static void main(String[] args) {
        Stack<Integer>[] stacks = new Stack[]{new Stack<Integer>(), new Stack<Integer>(), new Stack<Integer>()};
        for (int i = 0; i < tot; i++) {
            stacks[0].add(tot - i);
        }
        System.out.println(stacks[0] + "   " + stacks[1] + "   " + stacks[2]);

        moveFromTo(0, 2, stacks, tot);
    }

    private static void moveFromTo(int from, int to, Stack<Integer>[] stacks, int n) {
        if (n == 0) return;
        int other = 3 - from - to;

        moveFromTo(from, other, stacks, n - 1);

        final Integer popped = stacks[from].pop();
        stacks[to].push(popped);
        System.out.println(stacks[0] + "   " + stacks[1] + "   " + stacks[2]);

        moveFromTo(other, to, stacks, n - 1);
    }

}
