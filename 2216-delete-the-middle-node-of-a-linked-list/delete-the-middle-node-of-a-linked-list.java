/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode f = head.next, s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        if (s == null) return head;

        ListNode c = head, p = head;

        while (s.next != null) {
            p = c;
            c = c.next;
            s = s.next;
        }

        p.next = p.next.next;

        return head;
    }
}

/**

                                s
        p   
            c
1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

 */