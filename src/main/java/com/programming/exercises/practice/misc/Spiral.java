package com.programming.exercises.practice.misc;

public class Spiral {

    final static int size = 5;

    public static void main(String[] args) {
        int[][] matrix = new int[size][size];
        int row = 0, column = 0, num = 0;
        char direction = nextDirection('0');
        int nextRow, nextColumn;
        while (matrix[row][column] == 0) {

            matrix[row][column] = ++num;

            nextRow = nextRow(row, direction);
            nextColumn = nextColumn(column, direction);

            if (isValid(nextRow, nextColumn)) {
                if (matrix[nextRow][nextColumn] == 0) {
                    row = nextRow;
                    column = nextColumn;
                    continue;
                }
            }
            direction = nextDirection(direction);
            row = nextRow(row, direction);
            column = nextColumn(column, direction);
        }
        print(matrix);
    }

    private static int nextColumn(int column, int direction) {
        if (direction == 'R') {
            return column + 1;
        }
        if (direction == 'L') {
            return column - 1;
        }
        return column;
    }

    private static int nextRow(int row, int direction) {
        if (direction == 'U') {
            return row - 1;
        }
        if (direction == 'D') {
            return row + 1;
        }
        return row;
    }

    private static boolean isValid(int nextRow, int nextColumn) {
        return nextColumn >= 0 && nextColumn < Spiral.size
                && nextRow >= 0 && nextRow < Spiral.size;
    }

    private static char nextDirection(char direction) {
        switch (direction) {
            case 'R':
                return 'D';
            case 'D':
                return 'L';
            case 'L':
                return 'U';
            case 'U':
                return 'R';
        }
        return 'R';
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }
}
