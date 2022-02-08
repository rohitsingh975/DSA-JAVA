package com.company;


import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import java.util.HashMap;
import java.util.Scanner;

public class InterestingQueries {
    public static void main(String[] args) throws java.lang.Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            char c = in.next().charAt(0);
            long n = in.nextLong();
            int decN = (int) solve(n);
            if (c == '+') {
                map.put(decN, map.getOrDefault(decN, 0) + 1);
            } else if (c == '-') {
                if (map.containsKey(decN)) {
                    int cnt = map.get(decN);
                    cnt = cnt - 1;
                    map.put(decN, cnt);
                }
            } else if (c == '?') {
                int cnt = 0;
                if (map.containsKey(decN)) {
                    cnt += map.get(decN);
                }

                System.out.println(cnt);
            }
        }
    }

    static long solve(long temp) {

        long m = 1, ans = 0;

        while (temp > 0) {

            ans += ((temp % 10) & 1) * m;

            m *= 2;

            temp /= 10;

        }

        return ans;

    }
}
