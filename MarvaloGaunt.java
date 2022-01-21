package com.company;

import java.io.*;
import java.util.*;

public class MarvaloGaunt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long p = in.nextLong();
        long q = in.nextLong();
        long r = in.nextLong();

        long ans = Long.MIN_VALUE;
        long[] arr = new long[n];
        long[] pmax = new long[n];
        long[] smax = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }

        //Calculation of prefix sum
        pmax[0] = p * arr[0];
        for (int i = 1; i < n; i++) {
            pmax[i] = Math.max(pmax[i - 1], p * arr[i]);
        }

        //Calculation of suffix sum
        smax[n - 1] = r * arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            smax[i] = Math.max(smax[i + 1], r * arr[i]);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, pmax[i] + q * arr[i] + smax[i]);
        }

        System.out.println(ans);
    }
}
