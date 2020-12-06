package com.programming.exercises.practice.matrix;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 */
public class MatrixSetTo0 {

    private static final int n = 5;

    public static void main(String[] args) {
        System.out.println("\nInput");
        int[][] matrix = MatrixUtil.getRandomMatrix(n);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0){
                    setRowCol0(matrix, row, col);
                }
            }
        }
        
        // normalize
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == -9999){
                    matrix[row][col] = 0;
                }
            }
        }
        
        System.out.println("\nOutput");
        MatrixUtil.print(matrix);
    }

    private static void setRowCol0(int[][] matrix, int row, int col) {
        matrix[row][col] = -9999;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] == 0) setRowCol0(matrix, i, col);
            else matrix[i][col] = -9999;
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[row][i] == 0) setRowCol0(matrix, row, i);
            else matrix[row][i] = -9999;
        }
    }
}
