package com.dfs.leetcode531;

public class FindLonelyPixel {


    public int findLonelyPixel(char[][] picture) {

        int lenX = picture.length;
        int lenY = picture[0].length;
        int[] row = new int[lenX];

        for (int i = 0; i < lenX; i++) {
            row[i] = -1;
        }

        int[] col = new int[lenY];

        for (int i = 0; i < lenY; i++) {
            col[i] = -1;
        }
        int count = 0;

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {

                if (picture[i][j] == 'B') {

                    //row
                    int countX = dfsRow(picture, i, 0, lenY, row);

                    //column
                    int countY = dfsCol(picture, j, 0, lenX, col);

                    if (countX == 1 && countY == 1) {
                        count++;
                    }


                }

            }
        }

        return count;

    }

    private int dfsCol(char[][] picture, int j, int start, int end, int[] col) {

        if (col[j] != -1) {
            return col[j];
        }

        int count = 0;
        for (int index = start; index < end; index++) {
            if (picture[index][j] == 'B') {
                count++;
            }
        }
        col[j] = count;
        return count;
    }

    private int dfsRow(char[][] picture, int i, int start, int end, int[] row) {
        if (row[i] != -1) {
            return row[i];
        }

        int count = 0;
        for (int index = start; index < end; index++) {
            if (picture[i][index] == 'B') {
                count++;
            }
        }
        row[i] = count;
        return count;
    }


}
