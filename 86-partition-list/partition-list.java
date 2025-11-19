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
        ListNode beforeHead = new ListNode(-1);
        ListNode afterHead = new ListNode(-1);
        ListNode before = beforeHead, after = afterHead, cur = head;

        while (cur != null) {
            if (cur.val < x) {
                before.next = cur;
                before = before.next;
            } else {
                after.next = cur;
                after = after.next;
            }
            cur = cur.next;
        }

        before.next = afterHead.next;
        after.next = null;

        return beforeHead.next;
    }
}