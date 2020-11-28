package com.programming.exercises.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Util {

    public static ArrayList<Integer> randomArr(int size) {
        Random rd = new Random(); // creating Random object
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(Math.abs(rd.nextInt() % 100)); // storing random integers in an array
        }
        return arr;
    }

    public static ArrayList<Integer> randomSortedArr(int size) {
        final ArrayList<Integer> arr = randomArr(size);
        Collections.sort(arr);
        return arr;
    }

    public static ArrayList<Integer> randomRotatedSortedArr(int size) {
        final ArrayList<Integer> arr = randomSortedArr(size);

        Random rd = new Random(); // creating Random object
        final int distance = Math.abs(rd.nextInt()) % size;

        Collections.rotate(arr, distance);
        return arr;
    }

    public static String randomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }
}
