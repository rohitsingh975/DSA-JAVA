package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NeedAllOnes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] binary_matrix = new int[n][m];
        int[] heights = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                binary_matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            int col = n - 1;
            while (col >= 0 && binary_matrix[col][i] == 1) {
                cnt++;
                col--;
            }
            heights[i] = cnt;
        }
        //System.out.println(heights.length);

        int[] nse = new int[m];
        int[] pse = new int[m];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 0; i < m; i++) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                nse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (!st.empty()) {
            nse[st.peek()] = m;
            st.pop();
        }

        st.push(m - 1);
        for (int i = m - 2; i >= 0; i--) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                pse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (!st.empty()) {
            pse[st.peek()] = -1;
            st.pop();
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1));
        }
        System.out.println(maxArea);
    }
}
