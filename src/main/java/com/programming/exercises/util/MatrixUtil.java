package com.programming.exercises.util;

import org.apache.commons.lang3.RandomUtils;

public class MatrixUtil {

    public static int[][] getRandomMatrix(final int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = RandomUtils.nextInt() % 10;
            }
        }
        print(matrix);
        return matrix;
    }

    public static void print(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(", ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
