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
        
        ListNode h = new ListNode(-1);
        ListNode cur = h, p1 = l1, p2 = l2;
        int cry = 0;

        while (p1 != null || p2 != null || cry != 0) {
            int sm = getSm(new ListNode[]{p1, p2}, cry);

            ListNode node = new ListNode(sm % 10);
            cur.next = node;
            cur = node;

            cry = sm / 10;

            p1 = getNextNode(p1);
            p2 = getNextNode(p2);
        }

        return h.next;
    }

    private int getSm(ListNode[] nodes, int c) {
        int sum = c;

        for (ListNode l : nodes) {
            sum += l != null ? l.val : 0;
        }

        return sum;
    }

    private ListNode getNextNode(ListNode p) {
        return p == null ? null : p.next;
    }
}