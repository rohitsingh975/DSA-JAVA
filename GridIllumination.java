package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class GridIllumination {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] lamps = {{0, 0}, {4, 4}};
        int[][] queries = {{1, 1}, {1, 0}};
        System.out.println(Arrays.toString(gridIllumination(n, lamps, queries)));
    }

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[][] mat = new int[n][n];
        int k = queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < lamps.length; i++) {
            mat[lamps[i][0]][lamps[i][1]] = 1;
        }

        int[] row = new int[n];
        int[] col = new int[n];
        int[] minDig = new int[2 * n];
        int[] majDig = new int[2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                    majDig[i - j + (n - 1)] = 1;
                    minDig[i + j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (row[i] == 1 || col[j] == 1 || minDig[i + j] == 1)
                    mat[i][j] = 1;

        for (int[] row1 : mat)
            System.out.println(Arrays.toString(row1));
        return ans;
    }
}
