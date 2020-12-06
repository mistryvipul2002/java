package com.programming.exercises.practice.matrix;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 */
public class ImageRotate {
    private static final int n = 3;

    public static void main(String[] args) {
        System.out.println("\nInput");
        int[][] image = MatrixUtil.getRandomMatrix(n);
        int[][] imageRotated = new int[n][n];
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[row].length; col++) {
                imageRotated[col][image.length - 1 - row] = image[row][col];
            }
        }
        System.out.println("\nOutput");
        MatrixUtil.print(imageRotated);
    }

}
