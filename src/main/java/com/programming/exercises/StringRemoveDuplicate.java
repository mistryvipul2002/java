package com.programming.exercises;

import com.programming.exercises.util.Util;

/**
 * Remove the duplicate characters in a string
 */
public class StringRemoveDuplicate {
    static String str = "aaaaabbbbb";

    public static void main(String[] args) {
        final char[] chArr = str.toCharArray();
        removeDuplicates(chArr);
        System.out.println(chArr);
    }

    private static void removeDuplicates(char[] chArr) {
        if (chArr == null) {
            return;
        }

        for (int i = 0; i < chArr.length; i++) {
            for (int j = i + 1; j < chArr.length; j++) {
                if (chArr[i] == chArr[j]) {
                    chArr[j] = 0;
                }
            }
        }
    }
}
