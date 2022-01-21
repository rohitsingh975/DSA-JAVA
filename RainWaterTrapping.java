// Java implementation of the approach
package com.company;

import java.util.*;

class GFG {

    static int maxWater(int[] arr, int n) {

        // indices to traverse the array
        int left = 0;
        int right = n - 1;

        // To store Left max and right max
        // for two pointers left and right
        int l_max = 0;
        int r_max = 0;

        // To store the total amount
        // of rain water trapped
        int result = 0;
        while (left <= right) {

            // We need check for minimum of left
            // and right max for each element
            if (r_max <= l_max) {

                // Add the difference between
                // current value and right max at index r
                result += Math.max(0, r_max - arr[right]);

                // Update right max
                r_max = Math.max(r_max, arr[right]);

                // Update right pointer
                right -= 1;
            } else {

                // Add the difference between
                // current value and left max at index l
                result += Math.max(0, l_max - arr[left]);

                // Update left max
                l_max = Math.max(l_max, arr[left]);

                // Update left pointer
                left += 1;
            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] tokens = line.split(" ");
        int[] height = new int[tokens.length];
        for (int i = 0; i < height.length; i++)
            height[i] = Integer.parseInt(tokens[i]);

        int n = height.length;
        System.out.print(maxWater(height, n));
    }
}
