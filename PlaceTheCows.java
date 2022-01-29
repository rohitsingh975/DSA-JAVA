package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PlaceTheCows {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        int t = in.nextInt();
        while (t > 0) {
            int c = in.nextInt(), low = Integer.MAX_VALUE;

            if (c > n) {
                System.out.println(0);
                break;
            }


            Arrays.sort(x);

            for (int i = 0; i < n - 1; i++) {
                low = Math.min(x[i + 1] - x[i], low);
            }

            int high = x[n - 1] - x[0];

            while (low <= high) {

                int mid = (low + high) / 2;

                boolean r = isPoss(mid, c, n, x);

                if (!r) {
                    high = mid - 1;
                } else {

                    boolean r1 = isPoss(mid + 1, c, n, x);

                    if (!r1) {
                        System.out.println(mid);
                        break;
                    } else {
                        low = mid + 1;
                    }
                }
            }

            t--;
        }
    }

    static boolean isPoss(int m, int c, int n, int[] x) {
        int cnt = 1, pre = x[0];
        for (int i = 0; i < n; i++) {
            if (x[i] - pre < m)
                continue;
            else {
                cnt++;
                pre = x[i];
            }
        }
        return cnt >= c;
    }
}
