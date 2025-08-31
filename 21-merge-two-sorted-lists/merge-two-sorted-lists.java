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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            ListNode tmp = null;
            if (p1.val < p2.val) {
                tmp = p1;
                p1 = p1.next;
            } else {
                tmp = p2;
                p2 = p2.next;
            }
            tail.next = tmp;
            tail = tail.next;
        }

        tail.next = p1 == null ? p2 : p1;

        return head.next;
    }
}