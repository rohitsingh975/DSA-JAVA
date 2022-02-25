package com.company;

public class ReverseListRecursively {
    static ListNode1 head;

    // Inserts a new Node at front of the list.
    public void push(ListNode1 head_ref, int new_data) {
        // Allocate node
        ListNode1 new_node = new ListNode1(new_data, head_ref);

        // Move the head to point to the new node
        head = new_node;
    }

    // A utility function to print a
    // given linked list
    static void printList(ListNode1 head) {
        while (head != null) {
            System.out.print(head.val + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int val, ListNode1 next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode1 reverseList(ListNode1 p) {
        if (p == null || p.next == null)
            return p;
        ListNode1 tmp = p.next;
        p.next = null;
        ListNode1 head = reverseList(tmp);
        tmp.next = p;
        return head;
    }

    public static void main(String[] args) {
        ReverseListRecursively ll = new ReverseListRecursively();
        ll.push(head, 1);
        ll.push(head, 2);
        ll.push(head, 3);
        ll.push(head, 4);
        ll.push(head, 5);
        ListNode1 tmp = ll.reverseList(head);
        printList(tmp);
    }
}
