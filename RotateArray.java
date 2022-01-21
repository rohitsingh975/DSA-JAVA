package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int k = in.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        //part 1
        reverse(nums, 0, n - k - 1);

        //part 2
        reverse(nums, n - k, n - 1);

        //part 3
        reverse(nums, 0, n - 1);

    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}
