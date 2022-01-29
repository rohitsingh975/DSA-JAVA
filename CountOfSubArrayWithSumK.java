package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountOfSubArrayWithSumK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum = 0, cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];
            if (map.containsKey(psum - k)) {
                cnt += map.get(psum - k);
            }
            int count = map.containsKey(psum) ? map.get(psum) : 0;
            map.put(psum, count + 1);
        }
        return cnt;
    }
}
