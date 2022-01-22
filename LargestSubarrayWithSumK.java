package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LargestSubarrayWithSumK {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());

        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int[] arr = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }
            int res = lenOfLongSubarr(arr, sizeOfArray, K);
            System.out.println(res);

        }
    }

    public static int lenOfLongSubarr(int A[], int N, int K) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int ans = 0;
        int psum = 0;
        map.put(0, -1);

        // Traverse through the given array
        for (int i = 0; i < N; i++) {

            psum += A[i];

            if (map.containsKey(psum - K))
                ans = Math.max(ans, i - map.get(psum - K));
            if (!map.containsKey(psum))
                map.put(psum, i);

        }

        return ans;
    }
}
