package com.programming.exercises.practice.misc;

/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can only move in two directions: right and down. How many possible paths are there for the robot?
 * FOLLOW UP
 * Imagine certain squares are “off limits”, such that the robot can not step on them. Design an algorithm to get all possible paths for the robot.
 */
public class Robot {

    private static int[][] offlimit = {
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0},
    };

    public static void main(String[] args) {
        int[][] mat = new int[5][5];
        robot(mat, 0, 0, "");
    }

    private static void robot(int[][] mat, int row, int col, String buffer) {
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            System.out.println(buffer);
            return;
        }

        if (row < mat.length - 1 && offlimit[row + 1][col] == 0) {
            robot(mat, row + 1, col, buffer + "->down");
        }

        if (col < mat[0].length - 1 && offlimit[row][col + 1] == 0) {
            robot(mat, row, col + 1, buffer + "->right");
        }
    }
}
