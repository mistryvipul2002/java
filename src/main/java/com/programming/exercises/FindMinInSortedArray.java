package com.programming.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2. How would you find the minimum element?
 */
public class FindMinInSortedArray {

    static final int size = 10;

    public static void main(String[] args) {
        Integer[] arr = randomArr().toArray(new Integer[2]);
        int min = arr[0];
        for (Integer i : arr) {
            if (i < min) {
                min = i;
                break;
            }
        }

        System.out.println(min);
    }

    static ArrayList<Integer> randomArr() {
        Random rd = new Random(); // creating Random object
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(Math.abs(rd.nextInt() % 100)); // storing random integers in an array
        }
        Collections.sort(arr);
        final int distance = Math.abs(rd.nextInt()) % size;
        System.out.println("distance = " + distance);
        Collections.rotate(arr, distance);
        System.out.println(arr);
        return arr;
    }
}
