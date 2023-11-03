package com.company;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4}; // Example input array
        int target = 6; // Example target value

        int[] result = twoSum(nums, target);

        for (int num : result) {
            System.out.println(num);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{}; // No solution found
    }
}


