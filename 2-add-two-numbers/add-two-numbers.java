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
        ListNode out = new ListNode();
        ListNode head = out;

        ListNode p1 = l1, p2 = l2;
        int c = 0;

        while (p1 != null || p2 != null || c != 0) {
            int sm = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + c;

            ListNode nd = new ListNode(sm % 10);
            out.next = nd;

            out = nd;
            c = sm / 10;
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }

        return head.next;
    }
}