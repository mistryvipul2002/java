package com.programming.exercises.practice.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * Given an array of strings. Find unique pair of string indexes having same set of characters.
 */
public class NumUniquePairOfStrings {

    public static void main(String[] args) {
        System.out.println("Hello");
        final List<String> strList = Arrays.asList("may", "student", "students", "dog",
            "studentssess", "god", "cat", "act", "tab",
            "bat", "flow", "wolf", "lambs", "amy", "yam",
            "balms", "looped", "poodle");

        System.out.println(numUniquePairs(strList));
    }

    private static int numUniquePairs(List<String> strList) {
        strList = strList
            .stream()
            .map(String::chars)
            .map(charIntStream ->
                charIntStream
                    .mapToObj(i -> (char) i)
                    .distinct()
                    .sorted(Character::compareTo)
                    .collect(Collectors.toList())
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining())
            )
            .collect(Collectors.toList());

        System.out.println(strList);

        Set<ImmutablePair<Integer, Integer>> pairs = new HashSet<>();
        for (int i = 0; i < strList.size(); i++) {
            for (int j = i + 1; j < strList.size(); j++) {
                if (strList.get(i).equalsIgnoreCase(strList.get(j))) {
                    pairs.add(new ImmutablePair(i, j));
                }
            }
        }

        System.out.println(pairs);

        return pairs.size();
    }
}