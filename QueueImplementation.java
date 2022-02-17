package com.company;

import java.util.Scanner;

public class QueueImplementation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyQueue obj = new MyQueue();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();

                    obj.push(a);

                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }

    }
}


class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        //inserting x in the queue at rear.
        arr[rear++] = x;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
        //if front is equal to rear, queue is empty.
        if (front == rear)
            return -1;

        //else we return the element at front.
        return arr[front++];

    }
}





