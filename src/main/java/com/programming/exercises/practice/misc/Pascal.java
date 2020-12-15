package com.programming.exercises.practice.misc;

public class Pascal {

    public static void main(String arg[]) {
        printPascal(20);
    }

    public static void printPascal(int number) {
        int value = 1;
        for (int row = 0; row < number; row++) {
            // print spaces
            for (int i = 0; i < number - row; i++) {
                System.out.print("\t");
            }

            System.out.print(1);
            for (int i = 0; i < row; i++) {
                int oldValue = value;
                value = (value * (row - i)) / (i + 1);
                System.out.print("\t" + (oldValue >= 1000 ? "" : "\t"));
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
