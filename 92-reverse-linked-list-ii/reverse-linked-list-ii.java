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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        if (l == r) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;
        
        for (int i = 1; i < l; i++) {
            before = before.next;
        }

        ListNode cur = before.next;
        ListNode prev = before;

        for (int i = l; i <= r; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        before.next.next = cur;
        before.next = prev;

        return dummy.next;
    }    
}
