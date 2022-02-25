package com.company;

import java.util.Scanner;

public class CountOfSetBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(hammingWeight(n));
    }

    static int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n = (n & n - 1);
            cnt++;
        }
        return cnt;
    }
}
