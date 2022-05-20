package com.programming.exercises.practice.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomMathMultiply {

    public static void main(String[] args) {
        List<Data> listData = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        while (true) {

            int ans = 0;
            int a = 1 + random.nextInt(8);
            int b = 1 + random.nextInt(8);
            System.out.println(a + " x " + b);

            int attempts = 0;
            long start = System.currentTimeMillis();
            while (true) {
                attempts++;
                String line = scanner.nextLine();
                if (line.contains("done") || line.contains("exit")) {
                    Collections.sort(listData);
                    System.out.println(listData);
                    return;
                }

                try {
                    ans = Integer.parseInt(line);
                    if (ans != a * b) {
                        throw new Exception();
                    } else {
                        long end = System.currentTimeMillis();
                        final double timeInSecs = (end - start) / 1000.0;
                        System.out.println("Correct !!! You took " + timeInSecs + " seconds\n");
                        listData.add(new Data(a + " x " + b, timeInSecs, attempts));
                        break;
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}

class Data implements Comparable {

    String problemText;
    Double timeTaken;
    int attempts;

    public Data(String problemText, double timeTaken, int attempts) {
        this.problemText = problemText;
        this.timeTaken = timeTaken;
        this.attempts = attempts;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(timeTaken, ((Data) o).timeTaken);
    }

    @Override
    public String toString() {
        return "\nData{" +
            "problemText='" + problemText + '\'' +
            ", attempts=" + attempts +
            ", timeTaken=" + timeTaken + " seconds" +
            "}";
    }
}
