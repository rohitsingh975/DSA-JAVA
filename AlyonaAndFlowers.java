package com.company;

import java.util.Scanner;

public class AlyonaAndFlowers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), sum_of_subarray, total_happiness = 0;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        //prefix sum
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] += a[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            sum_of_subarray = a[r] - a[l - 1];
            sum_of_subarray += total_happiness;
            total_happiness = Math.max(total_happiness, sum_of_subarray);
        }

        if (total_happiness < 0)
            total_happiness = 0;

        System.out.println(total_happiness);
    }
}
