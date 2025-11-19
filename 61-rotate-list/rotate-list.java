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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode oldHead = head, oldTail = head;

        int len = 1;
        while (oldTail.next != null) {
            len++;
            oldTail = oldTail.next;
        }

        int offset = Math.abs(k) % len;
        if (offset == 0) return head;

        int pos = len - offset;
        ListNode newTail = head;

        for (int i = 1; i < pos; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        oldTail.next = head;

        return newHead;
    }
}