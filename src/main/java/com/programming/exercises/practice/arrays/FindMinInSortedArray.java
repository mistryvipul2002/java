package com.programming.exercises.practice.arrays;

import com.programming.exercises.util.Util;

import java.util.ArrayList;

/**
 * A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2. How would you find the minimum element?
 */
public class FindMinInSortedArray {

    public static void main(String[] args) {
        final ArrayList<Integer> arrList = Util.randomRotatedSortedArr(10);
        System.out.println(arrList);

        Integer[] arr = arrList.toArray(new Integer[2]);
        int min = arr[0];
        for (Integer i : arr) {
            if (i < min) {
                min = i;
                break;
            }
        }

        System.out.println(min);
    }

}
