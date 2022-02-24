package com.company;

public class RemoveNthNodeFromEnd {

    // Head of linked list
    static Node1 head;

    class Node1 {
        int data;
        Node1 next;


        // Constructor
        public Node1(Node1 next,
                     int data) {
            this.data = data;
            this.next = next;
        }
    }

    // Inserts a new Node at front of the list.
    public void push(Node1 head_ref, int new_data) {
        // Allocate node
        Node1 new_node = new Node1(head_ref, new_data);

        // Move the head to point to the new node
        head = new_node;
    }

    // A utility function to print a
    // given linked list
    static void printList(Node1 head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }


    public static Node1 removeNthFromEnd(Node1 head, int n) {
        Node1 p1 = head;
        Node1 p2 = head;
        int c = 0;

        while (c < n) {
            p2 = p2.next;
            c++;
        }

        if (p2 == null) {
            Node1 tmp = head.next;
            return tmp;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        Node1 tmp = p1.next;
        p1.next = p1.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd ll = new RemoveNthNodeFromEnd();
        ll.push(head, 1);
        ll.push(head, 2);
        ll.push(head, 3);
        ll.push(head, 4);
        ll.push(head, 5);
        Node1 tmp = ll.removeNthFromEnd(head, 2);
        System.out.println(tmp.data);
    }


}
