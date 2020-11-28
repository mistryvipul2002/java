package com.programming.exercises;

/**
 * Design an algorithm to print all permutations of a string. For simplicity, assume all characters are unique.
 * Test String: abcdefg
 * Case “a” --> {a}
 * Case “ab” --> {ab, ba}
 * Case “abc” --> ?
 */
public class StringPermutations {

    public static void main(String[] args) {
        perm("", "abc");
    }

    static void perm(String prefix, String str) {
        final int len = str.length();
        if (len == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < len; i++) {
            final String restOfString = str.substring(0, i) + str.substring(i + 1);
            perm(prefix + str.charAt(i), restOfString);
        }
    }

}
