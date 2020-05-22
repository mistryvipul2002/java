package com.programming.exercises.hanoi;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(7, 'A', 'B', 'C');
    }

    static void hanoi(int n, char a, char b, char c) {
        if (n == 0) return;
        hanoi(n - 1, a, c, b);
        System.out.println("Move " + n + " from " + a + " to " + c);
        hanoi(n - 1, b, a, c);
    }
}
