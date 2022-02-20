package com.company;


import java.util.ArrayDeque;

public class StackImplementationUsingQueue {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False
    }
}

class MyStack {
    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<Integer>();
        q2 = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        while (!q1.isEmpty())
            q2.offer(q1.poll());
        q1.offer(x);
        while (!q2.isEmpty())
            q1.offer(q2.poll());
    }

    public int pop() {
        return q1.pop();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
