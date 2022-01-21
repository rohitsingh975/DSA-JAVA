package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

public class KthSmallestInMultiplicationTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();

            int low = 1, high = m * n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                int capacity = count(mid, m, n);
                if (capacity >= k) high = mid;
                else low = mid + 1;
            }
            System.out.println(low);
            T--;
        }
    }

    private static int count(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(mid / i, n);
            count += temp;
        }
        return count;
    }
}
