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
        ArrayDeque<Integer> st1 = new ArrayDeque<>();
        ArrayDeque<Integer> st2 = new ArrayDeque<>();

        ListNode res = null;

        ListNode p1 = l1, p2 = l2;

        while (p1 != null) {
            st1.push(p1.val);
            p1 = p1.next;
        }

        while (p2 != null) {
            st2.push(p2.val);
            p2 = p2.next;
        }

        int carry = 0;
        while (!st1.isEmpty() || !st2.isEmpty() || carry > 0) {
            int sum = (st1.isEmpty() ? 0 : st1.pop()) + 
                      (st2.isEmpty() ? 0 : st2.pop()) +
                      carry;

            ListNode head = new ListNode(sum % 10);
            head.next = res;

            res = head;

            carry = sum / 10;
        }

        return res;
    }
}