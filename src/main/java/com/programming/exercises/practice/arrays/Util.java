package com.programming.exercises.practice.arrays;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Util {

    public static ArrayList<Integer> randomArrayList(final int size) {
        Random rd = new Random(); // creating Random object
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(Math.abs(rd.nextInt() % 100)); // storing random integers in an array
        }
        return arr;
    }

    public static int[] randomArray(final int size) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.abs(rd.nextInt() % 100); // storing random integers in an array
        }
        return arr;
    }

    public static ArrayList<Integer> randomSortedArrayList(int size) {
        final ArrayList<Integer> arr = randomArrayList(size);
        Collections.sort(arr);
        return arr;
    }

    public static ArrayList<Integer> randomRotatedSortedArrayList(int size) {
        final ArrayList<Integer> arr = randomSortedArrayList(size);

        Random rd = new Random(); // creating Random object
        final int distance = Math.abs(rd.nextInt()) % size;

        Collections.rotate(arr, distance);
        return arr;
    }

    public static String randomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
