package com.company;

import java.util.Arrays;

public class MaxRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        //Transforming given binary matrix to matrix of size of histogram
        for (int c = 0; c < column; c++) {
            for (int i = 1; i < row; i++) {
                if (matrix[i][c] != '0') {
                    matrix[i][c] = (char) (1 + (int) (matrix[i - 1][c]));
                }
            }
        }

        
        System.out.println(Arrays.deepToString(matrix));
        return 0;
    }

}
