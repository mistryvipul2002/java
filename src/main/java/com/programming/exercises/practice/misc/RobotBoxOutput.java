package com.programming.exercises.practice.misc;

/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can only move in two directions: right and down. How many possible paths are there for the robot?
 * FOLLOW UP
 * Imagine certain squares are “off limits”, such that the robot can not step on them. Design an algorithm to get all possible paths for the robot.
 */
public class RobotBoxOutput {

    // place "1" to block (no route through that point)
    private static final int[][] offlimit = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

    public static void main(String[] args) {
        int[][] mat = new int[4][4];
        robot(mat, 0, 0, new char[mat.length][mat[0].length]);
    }

    private static void robot(int[][] mat, int row, int col, char[][] buffer) {
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            for (int i = 0; i < buffer.length; i++) {
                for (int j = 0; j < buffer[0].length; j++) {
                    final char c = buffer[i][j];
                    System.out.print(c == '\u0000' ? ' ' : c);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // go down
        if (row < mat.length - 1 && offlimit[row + 1][col] == 0) {
            final char[][] newBuffer = deepCopy(buffer);
            if(newBuffer[row][col] == '\u0000') newBuffer[row][col] = '\u2502';
            else if(newBuffer[row][col] == '\u2500') newBuffer[row][col] = '\u2510';
            newBuffer[row+1][col] = '\u2502';
            robot(mat, row + 1, col, newBuffer);
        }

        // go right
        if (col < mat[0].length - 1 && offlimit[row][col + 1] == 0) {
            final char[][] newBuffer = deepCopy(buffer);
            if(newBuffer[row][col] == '\u0000') newBuffer[row][col] = '\u2500';
            else if(newBuffer[row][col] == '\u2502') newBuffer[row][col] = '\u2514';
            newBuffer[row][col + 1] = '\u2500';
            robot(mat, row, col + 1, newBuffer);
        }
    }

    private static char[][] deepCopy(char[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }
}
