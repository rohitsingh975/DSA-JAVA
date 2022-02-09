package com.company;

import java.util.Arrays;
import java.util.Stack;

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
        int maxArea = Integer.MIN_VALUE;

        int[][] intMatrix = new int[row][column];

        //Transforming given binary matrix to matrix of size of histogram
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (j == 0) {
                    intMatrix[0][i] = matrix[0][i] == '0' ? 0 : 1;
                    continue;
                }
                intMatrix[j][i] = matrix[j][i] == '0' ? 0 : intMatrix[j - 1][i] + 1;
            }
        }
        //System.out.println(Arrays.deepToString(intMatrix));

        for (int r = row - 1; r >= 0; r--) {
            int n = intMatrix[r].length;

            int[] nse = new int[n];
            int[] pse = new int[n];
            Stack<Integer> st = new Stack<>();

            st.push(0);
            for (int i = 1; i < n; i++) {
                while (!st.empty() && intMatrix[r][i] < intMatrix[r][st.peek()]) {
                    nse[st.peek()] = i;
                    st.pop();
                }
                st.push(i);
            }

            while (!st.empty()) {
                nse[st.peek()] = n;
                st.pop();
            }

            st.push(n - 1);
            for (int i = n - 2; i >= 0; i--) {
                while (!st.empty() && intMatrix[r][i] < intMatrix[r][st.peek()]) {
                    pse[st.peek()] = i;
                    st.pop();
                }
                st.push(i);
            }

            while (!st.empty()) {
                pse[st.peek()] = -1;
                st.pop();
            }

            for (int i = 0; i < n; i++) {
                maxArea = Math.max(maxArea, intMatrix[r][i] * (nse[i] - pse[i] - 1));
            }
        }
        return maxArea;
    }

}
