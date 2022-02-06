package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
            long[] res = nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }

    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        long[] ans = new long[n];
        for (int i = 1; i < n; i++) {
            while (!stk.empty() && arr[i] > arr[stk.peek()]) {
                ans[stk.peek()] = arr[i];
                stk.pop();
            }
            stk.push(i);
        }

        while (!stk.empty()) {
            ans[stk.peek()] = -1;
            stk.pop();
        }

        return ans;
    }
}


//class Solution
//{
//    //Function to find the next greater element for each element of the array.
//    public static long[] nextLargerElement(long[] arr, int n)
//    {
//        Stack<Long> s = new Stack<>();
//        long nge[] = new long[n];
//
//        //traversing the array from last element in backward direction.
//        for (int i = n - 1; i >= 0; i--)
//        {
//            if (!s.empty())
//            {
//                //while element at top of stack is less than or equal to
//                //current array element, we pop elements from the stack.
//                while (!s.empty() && s.peek() < arr[i]) {
//                    s.pop();
//                }
//            }
//            //if stack becomes empty, we store -1 in the answer list
//            //else we store the top element of the stack.
//            nge[i] = s.empty() ? -1 : s.peek();
//
//            //pushing the current array element into the stack.
//            s.push(arr[i]);
//        }
//        //returning the list.
//        return nge;
//
//    }
//}
