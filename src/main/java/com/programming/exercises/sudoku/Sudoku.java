package com.programming.exercises.sudoku;

import java.util.ArrayList;

public class Sudoku {
    private static Cell[][] sudo = new Cell[9][9];

    static {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                sudo[i][j] = new Cell();
            }
    }

    public static void main(String[] args) {
        populate(sudo);
        System.out.println(print());
        boolean shouldContinue = true;
        int it = 0;
        while (shouldContinue) {
            //start with first 3x3 square. Let its position is (x,y) where 0<=x,y<=2
            for (int x = 0; x < 3; x++)
                for (int y = 0; y < 3; y++) {
                    //now we have got our (x,y) 3x3 square 
                    for (int i = 3 * x; i < 3 * x + 3; i++)
                        for (int j = 3 * y; j < 3 * y + 3; j++) {
                            // we got (i,j) cell to operate on
                            int value = sudo[i][j].data;
                            if (value != 0) {
                                //Step 1: reduce probability for (x,y) square
                                reduceProbabiltyForSmallSquare(x, y, value);
                                //Step 2: reduce probability for (9,9) grid sudo 
                                reduceProbabiltyForBigSquare(i, j, value);
                            }
                        }
                }
            System.out.println("\n\n\n");
            System.out.println(print() + "\n\n\n");
            // normalize
            shouldContinue = normalize() || normalizeForSpecificElements();// || normalizeRowCol();
            it++;
        }
        System.out.println(it);
    }

    private static boolean normalizeRowCol() {
        boolean flag = false;
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++) {
                //now we have got our (x,y) 3x3 square
                for (int num = 0; num < 9; num++) {
                    boolean exists[] = {false, false, false};
                    for (int i = 3 * x, count = 0; i < 3 * x + 3; i++, count++) {
                        // check for (num+1) prob in row i
                        for (int j = 3 * y; j < 3 * y + 3; j++)
                            if (sudo[i][j].prob.contains(new Integer(num + 1))) exists[count] = true;
                    }
                    if (exists[0] && !exists[1] && !exists[2]) {
                        //remove num+1 from all prob in row 3*x
                        for (int i = 0; i < 9; i++) {
                            if (3 * y <= i && i < 3 * y + 3) continue;
                            if (sudo[3 * x][i].prob.contains(new Integer(num + 1))) flag = true;
                            sudo[3 * x][i].prob.remove(new Integer(num + 1));
                        }
                    }
                    if (!exists[0] && exists[1] && !exists[2]) {
                        //remove num+1 from all prob in row 3*x+1
                        for (int i = 0; i < 9; i++) {
                            if (3 * y <= i && i < 3 * y + 3) continue;
                            if (sudo[3 * x + 1][i].prob.contains(new Integer(num + 1))) flag = true;
                            sudo[3 * x + 1][i].prob.remove(new Integer(num + 1));
                        }
                    }
                    if (!exists[0] && !exists[1] && exists[2]) {
                        //remove num+1 from all prob in row 3*x+2
                        for (int i = 0; i < 9; i++) {
                            if (3 * y <= i && i < 3 * y + 3) continue;
                            if (sudo[3 * x + 2][i].prob.contains(new Integer(num + 1))) flag = true;
                            sudo[3 * x + 2][i].prob.remove(new Integer(num + 1));
                        }
                    }
                }
            }
        return flag;
    }

    private static boolean normalizeForSpecificElements() {
        boolean flag = false;
        ArrayList cells = new ArrayList();
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++) {
                //now we have got our (x,y) 3x3 square 
                for (int i = 3 * x; i < 3 * x + 3; i++)
                    for (int j = 3 * y; j < 3 * y + 3; j++) {
                        cells.add(sudo[i][j]);
                    }
                if (normalizeNineSpecificElements(cells)) flag = true;
            }

        //check rows
        for (int i = 0; i < 9; i++) {
            cells = new ArrayList();
            for (int j = 0; j < 9; j++) cells.add(sudo[i][j]);
            if (normalizeNineSpecificElements(cells)) flag = true;
        }

        //check column
        for (int i = 0; i < 9; i++) {
            cells = new ArrayList();
            for (int j = 0; j < 9; j++) cells.add(sudo[j][i]);
            if (normalizeNineSpecificElements(cells)) flag = true;
        }
        return flag;
    }

    private static boolean normalizeNineSpecificElements(ArrayList cells) {
        Object[] arr = cells.toArray();
        boolean flag = false;
        for (int num = 0; num < 9; num++) {
            int count = 0, pos = 0;
            for (int i = 0; i < arr.length; i++)
                if (((Cell) arr[i]).prob.contains(new Integer(num + 1))) {
                    count++;
                    pos = i;
                }
            if (count == 1) {
                // its time now to fix this cell[i] with value probab.
                ((Cell) arr[pos]).data = num + 1;
                ((Cell) arr[pos]).prob = new ArrayList();
                flag = true;
            }
        }
        return flag;
    }

    private static boolean normalize() {
        boolean flag = false;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (sudo[i][j].prob.size() == 1) {
                    sudo[i][j].data = ((Integer) sudo[i][j].prob.get(0)).intValue();
                    sudo[i][j].prob = new ArrayList();
                    flag = true;
                }
            }
        return flag;
    }

    private static void reduceProbabiltyForSmallSquare(int x, int y, int value) {
        for (int i = 3 * x; i < 3 * x + 3; i++)
            for (int j = 3 * y; j < 3 * y + 3; j++) {
                // reduce prob of all (i,j) in (x,y) square for the value 'value'
                sudo[i][j].prob.remove(new Integer(value));
            }
    }

    private static void reduceProbabiltyForBigSquare(int p, int q, int value) {
        //in row p, reduce value
        for (int j = 0; j < 9; j++) {
            sudo[p][j].prob.remove(new Integer(value));
        }
        //in column q, reduce value
        for (int i = 0; i < 9; i++) {
            sudo[i][q].prob.remove(new Integer(value));
        }
    }

    private static void populate(Cell[][] sudo2) {
        int arr[][] =
                {
                        //simple
//			{0,4,0,0,0,0,0,6,0},
//			{0,7,0,2,0,6,0,9,0},
//			{5,0,0,7,9,8,0,0,2},
//			{0,0,2,4,0,9,6,0,0},
//			{9,0,0,0,0,0,0,0,5},
//			{0,0,4,6,0,3,1,0,0},
//			{6,0,0,3,8,4,0,0,7},
//			{0,9,0,5,0,1,0,2,0},
//			{0,3,0,0,0,0,0,1,0},


                        //medium

//			{0,1,0,3,0,8,0,6,0},
//			{2,0,0,0,0,0,0,0,9},
//			{0,5,0,0,2,0,0,7,0},
//			{8,0,0,0,3,0,0,0,1},
//			{5,3,0,0,6,0,0,9,2},
//			{4,0,0,0,9,0,0,0,5},
//			{0,9,0,0,1,0,0,5,0},
//			{7,0,0,0,0,0,0,0,6},
//			{0,4,0,5,0,3,0,2,0},

//			//hardest
//		
//			{0,7,0,1,0,0,0,6,0},
//			{9,0,0,0,7,0,0,0,1},
//			{0,0,3,8,9,0,2,0,0},
//			{0,0,0,0,0,0,7,0,9},
//			{0,6,7,0,0,0,1,5,0},
//			{8,0,9,0,0,0,0,0,0},
//			{0,0,1,0,6,7,4,0,0},
//			{7,0,0,0,4,0,0,0,5},
//			{0,2,0,0,0,3,0,1,0},

                        //more hardest

                        {0, 0, 0, 0, 2, 0, 8, 0, 0},
                        {4, 2, 0, 0, 0, 1, 0, 3, 0},
                        {0, 0, 0, 0, 6, 0, 0, 0, 2},
                        {0, 0, 7, 6, 0, 0, 0, 1, 3},
                        {0, 0, 0, 9, 0, 3, 0, 0, 0},
                        {3, 8, 0, 0, 0, 5, 6, 0, 0},
                        {6, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 9, 0, 8, 0, 0, 0, 6, 5},
                        {0, 0, 2, 0, 9, 0, 0, 0, 0},
                };

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                sudo[i][j].data = arr[i][j];
                if (sudo[i][j].data == 0) {
                    for (int t = 0; t < 9; t++)
                        sudo[i][j].prob.add(new Integer(t + 1));
                } else sudo[i][j].prob = new ArrayList();
            }
    }

    public static String print() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append("" + sudo[i][j].data + sudo[i][j].prob + ", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}