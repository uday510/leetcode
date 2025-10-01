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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head, p1 = l1, p2 = l2;
        int rem = 0;

        while (p1 != null || p2 != null || rem != 0) {
            int sum = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + rem;

            ListNode newNode = new ListNode(sum % 10);
            cur.next = newNode;
            cur = cur.next;

            rem = sum / 10;
            p1 = (p1 != null ? p1.next : null);
            p2 = (p2 != null ? p2.next : null);
        }

        return head.next;
    }
}