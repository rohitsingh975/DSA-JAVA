package com.company;

import java.util.Stack;

public class QueueImplementationUsingStack {
    public static void main(String[] args) {
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}

class MyQueue1 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int front, bottomOfs1;

    public MyQueue1() {

    }

    public void push(int x) {
        if (s1.empty() && s2.empty())
            front = x;
        else if (s1.empty())
            bottomOfs1 = x;
        s1.push(x);
    }

    public int pop() {
        int ans;
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.peek());
                s1.pop();
            }
        }
        ans = s2.peek();
        s2.pop();
        if (!s2.empty())
            front = s2.peek();
        else if (!s1.empty())
            front = bottomOfs1;

        return ans;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
