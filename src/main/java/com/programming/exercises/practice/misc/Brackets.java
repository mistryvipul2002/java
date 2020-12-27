package com.programming.exercises.practice.misc;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
 * EXAMPLE:
 * input: 3 (e.g., 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((()))
 */
public class Brackets {

    public static void main(String[] args) {
        int n = 3;
        brackets(n, n, "");
    }

    private static void brackets(int remainL, int remainR, String buffer) {
        // add left
        if (remainL > 0) {
            brackets(remainL - 1, remainR, buffer + "(");
        }

        // add right
        if (remainR > 0) {
            if (remainR > remainL) {
                brackets(remainL, remainR - 1, buffer + ")");
            }
        }

        if (remainL == 0 && remainR == 0) {
            System.out.println(buffer);
        }
    }
}
