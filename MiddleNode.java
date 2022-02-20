package com.company;

import java.util.LinkedList;

public class MiddleNode {

    // Head of linked list
    static Node head;

    class Node {
        int data;
        Node next;


        // Constructor
        public Node(Node next,
                    int data) {
            this.data = data;
            this.next = next;
        }
    }

    // Inserts a new Node at front of the list.
    public void push(Node head_ref, int new_data) {
        // Allocate node
        Node new_node = new Node(head_ref,
                new_data);

        // Move the head to point to the new node
        head = new_node;
    }

    // A utility function to print a
    // given linked list
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
        return slow;
    }

    public static void main(String[] args) {
        MiddleNode ll = new MiddleNode();
        ll.push(head, 1);
        ll.push(head, 2);
        ll.push(head, 3);
        ll.push(head, 4);
        ll.push(head, 5);
        ll.middleNode(head);
    }


}
