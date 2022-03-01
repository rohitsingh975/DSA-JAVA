package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Reading total number of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            //Reading total number of elements
            int n = Integer.parseInt(br.readLine());

            //Creating a Queue
            Queue<Integer> q = new LinkedList<>();

            //Reading all the elements in a string
            String s = br.readLine();

            //Spliting the string into different
            //string separated by space
            String[] a = s.split(" ");

            //adding all the elements to the Queue
            for (String b : a) {
                int x = Integer.parseInt(b);
                q.add(x);
            }


            //calling rev method of class Geeks
            q = rev(q);

            //printing the elements of the queue
            while (!q.isEmpty()) {
                int x = q.peek();
                q.poll();
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static Queue<Integer> rev(Queue<Integer> q) {
        //add code here.
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            int x = q.peek();
            s.push(q.peek());
            q.remove(x);
        }

        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
        }

        return q;
    }
}


