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
    public ListNode partition(ListNode head, int x) {
        
        ListNode bH = new ListNode(-1);
        ListNode aH = new ListNode(-1);
        ListNode b = bH, a = aH, c = head;

        while (c != null) {
            if (c.val < x) {
                b.next = c;
                b = b.next;
            } else {
                a.next = c;
                a = a.next;
            }

            c = c.next;
        }

        b.next = aH.next;
        a.next = null;

        return bH.next;
    }
}