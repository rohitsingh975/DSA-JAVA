package com.company;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is "
                + maxLen(arr));
    }

    // Returns length of the maximum length subarray with 0 sum
    static int maxLen(int arr[]) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int ans = 0;
        int psum = 0;
        map.put(0, -1);

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {

            psum += arr[i];

            if (!map.containsKey(psum))
                map.put(psum, i);
            else
                ans = Math.max(ans, i - map.get(psum));
        }

        return ans;
    }
}
