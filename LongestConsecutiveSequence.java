package com.company;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (m.containsKey(num)) {
                continue;
            } else {
                int ls = 0, rs = 0;
                if (m.containsKey(num - 1))
                    ls = m.get(num - 1);
                if (m.containsKey(num + 1))
                    rs = m.get(num + 1);
                ans = Math.max(ans, 1 + ls + rs);
                m.put(num, 1 + ls + rs);
                m.put(num - ls, 1 + ls + rs);
                m.put(num + rs, 1 + ls + rs);
            }
        }
        return ans;
    }
}
