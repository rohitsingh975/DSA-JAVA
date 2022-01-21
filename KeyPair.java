package com.company;

import java.io.*;
import java.util.*;

public class KeyPair {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Solution obj = new Solution();
        boolean ans = obj.hasArrayTwoCandidates(arr, n, x);
        System.out.println(ans);
    }
}

class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        HashMap<Integer, Integer> map;
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(x - arr[i]))
                return true;
            map.put(arr[i], 0);
        }
        return false;
    }
}