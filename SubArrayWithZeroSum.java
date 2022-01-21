package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        System.out.println(findsum(arr, n) == true ? "Yes" : "No");
    }

    static boolean findsum(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum = 0;
        map.put(psum, 1);
        for (int i = 0; i < n; i++) {
            psum += arr[i];
            if (map.containsKey(psum))
                return true;
            map.put(psum, 1);
        }
        return false;


    }
}
