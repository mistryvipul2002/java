package com.programming.exercises.practice.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {

    public static void main(String[] args) {
        System.out.println(findDuplicates(Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5, 3, 6)));
    }

    private static Set<Integer> findDuplicates(List<Integer> numList) {
        Set<Integer> s = new HashSet<>();
        Set<Integer> ret = new HashSet<>();
        numList.forEach(i -> {
            if (s.contains(i)) {
                ret.add(i);
            } else {
                s.add(i);
            }
        });
        return ret;
    }
}
