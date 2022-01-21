package com.company;

import java.util.Scanner;

public class MaxChunkToSorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int ans = maxChunksToSorted(arr);
        System.out.println(ans);
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int current_max = Integer.MIN_VALUE;
        int max_number_of_chunks = 0;

        if (n <= 0)
            return 0;


        for (int i = 0; i < n; i++) {
            current_max = Math.max(current_max, arr[i]);
            if (current_max == i)
                max_number_of_chunks++;
        }

        return max_number_of_chunks;

    }
}


