package com.company;

public class isPalindrome1 {
    static ListNode2 head;

    // Inserts a new Node at front of the list.
    public void push(ListNode2 head_ref, int new_data) {
        // Allocate node
        ListNode2 new_node = new ListNode2(new_data, head_ref);

        // Move the head to point to the new node
        head = new_node;
    }

    // A utility function to print a
    // given linked list
    static void printList(ListNode2 head) {
        while (head != null) {
            System.out.print(head.val + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public class ListNode2 {
        int val;
        ListNode2 next;

        ListNode2(int val, ListNode2 next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode2 middleNode(ListNode2 head) {
        ListNode2 slow = head;
        ListNode2 fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //System.out.println(slow.val);
        return slow;
    }

    static ListNode2 reverseList(ListNode2 head) {
        if (head == null) {
            return null;
        }

        ListNode2 prev = null;
        ListNode2 curr = head;

        while (curr != null) {
            ListNode2 tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    static boolean isPalindrome(ListNode2 head) {
        ListNode2 mid = middleNode(head);
        ListNode2 t = reverseList(mid);
        ListNode2 h = head;
        while (h != null && t != null) {
            if (h.val != t.val)
                return false;
            h = h.next;
            t = t.next;
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome1 ll = new isPalindrome1();
        ll.push(head, 1);
        ll.push(head, 2);
        ll.push(head, 2);
        ll.push(head, 1);

        System.out.println(isPalindrome(head));
    }
}
