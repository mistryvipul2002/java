package com.programming.exercises.practice.misc;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);

    }
}
