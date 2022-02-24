package com.company;

import java.util.Scanner;

public class isPowerOfTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(isPowerOfTwo1(n));

    }

    static boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
