package com.company;

public class FirstNodeOfCycle {

    class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode1 detectCycle(ListNode1 head) {
        ListNode1 slow = head;
        ListNode1 fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle)
            return null;
        ListNode1 p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }

    public static void main(String[] args) {

    }
}
