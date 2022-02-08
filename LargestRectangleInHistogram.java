package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                nse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()) {
            nse[st.peek()] = n;
            st.pop();
        }

        //System.out.println(Arrays.toString(nse));
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
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
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1));
        }

        return maxArea;
    }
}
