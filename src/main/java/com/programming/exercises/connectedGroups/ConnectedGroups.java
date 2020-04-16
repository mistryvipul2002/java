package com.programming.exercises.connectedGroups;

/**
 * Find groups of connected blue or red dots in a matrix
 * Sample Input is
 * XXXXX
 * RRXMB
 * XRRXB
 */
public class ConnectedGroups {

    private static int countR = 0;
    private static int countB = 0;
    private static int length = 0;
    private static int height = 0;


    public static void main(String[] args) {
        // set defaults
        if (args == null || args.length == 0) {
            args = new String[]{
                    "XXXXX",
                    "RRXMB",
                    "XRRXB"
            };
        }

        length = args.length;
        height = args[0].length();

        char[][] arr = new char[length][height];

        for (int i = 0; i < length; i++) {
            arr[i] = args[i].toCharArray();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'X') {
                    continue;
                }

                char ch = arr[i][j];
                if (ch == 'R') {
                    countR++;
                }
                if (ch == 'B') {
                    countB++;
                }
                if (ch == 'M') {
                    countR++;
                    countB++;
                }

                arr[i][j] = 'X';
                markGroup(i, j, ch, arr);
            }
        }

        System.out.println(countR + "R " + countB + "B");

    }

    private static void markGroup(int i, int j, char ch, char[][] arr) {
        traverse(ch, i - 1, j - 1, arr);
        traverse(ch, i - 1, j, arr);
        traverse(ch, i - 1, j + 1, arr);

        traverse(ch, i, j - 1, arr);
        traverse(ch, i, j + 1, arr);

        traverse(ch, i + 1, j - 1, arr);
        traverse(ch, i + 1, j, arr);
        traverse(ch, i + 1, j + 1, arr);

    }

    private static void traverse(char ch, int x, int y, char[][] arr) {
        if (!valid(x, y)) return;

        if (arr[x][y] == ch) {
            arr[x][y] = 'X';
            markGroup(x, y, ch, arr);
        }

        if (ch == 'M') {
            if (arr[x][y] == 'R') {
                arr[x][y] = 'X';
                markGroup(x, y, 'R', arr);
            }
            if (arr[x][y] == 'B') {
                arr[x][y] = 'X';
                markGroup(x, y, 'B', arr);
            }
        }
        if (ch == 'R' && arr[x][y] == 'M') {
            arr[x][y] = 'B';
            markGroup(x, y, 'R', arr);
        }
        if (ch == 'B' && arr[x][y] == 'M') {
            arr[x][y] = 'R';
            markGroup(x, y, 'B', arr);
        }
    }

    private static boolean valid(int i, int j) {
        return i >= 0 && i < length && j >= 0 && j < height;
    }


}