package com.company;

public class ReverseListIteratively {

    static ListNode head;

    // Inserts a new Node at front of the list.
    public void push(ListNode head_ref, int new_data) {
        // Allocate node
        ListNode new_node = new ListNode(new_data, head_ref);

        // Move the head to point to the new node
        head = new_node;
    }

    // A utility function to print a
    // given linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseListIteratively ll = new ReverseListIteratively();
        ll.push(head, 1);
        ll.push(head, 2);
        ll.push(head, 3);
        ll.push(head, 4);
        ll.push(head, 5);
        ListNode tmp = ll.reverseList(head);
        printList(tmp);
    }


}
