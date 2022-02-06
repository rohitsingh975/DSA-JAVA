package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ConsecutiveElement {
    public static void main(String[] args) throws IOException, IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            boolean ans = areConsecutives(a, n);
            // System.out.println(ob.shuffleArray(a,n));
            if (ans)
                System.out.println("Yes");
            else
                System.out.println("No");

        }
    }

    static boolean areConsecutives(long arr[], int N) {
        HashMap<Long, Long> m = new HashMap<Long, Long>();
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            m.put(arr[i], 0L);
            min = Math.min(min, arr[i]);
        }

        for (long i = min; i < min + N; i++) {
            if (!m.containsKey(i))
                return false;
        }
        return true;
    }
}


//Alternative approach without hashmap
//bool areConsecutives(long long arr[], int n)
//{
//    // Find minimum element in array
//    long long first_term = *(min_element(arr, arr + n));
//
//    // Calculate AP sum
//    long long ap_sum = (n * (2 * first_term + (n - 1) * 1)) / 2;
//
//    // Calculate given array sum
//    long long arr_sum = 0;
//    for (int i = 0; i < n; i++)
//        arr_sum += arr[i];
//
//    // Compare both sums and return
//    return ap_sum == arr_sum;
//}