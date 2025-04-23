class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        int rem = 0;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null || p2 != null || rem != 0) {
            int val = rem + (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val);
            tail.next = new ListNode(val % 10);
            tail = tail.next;

            rem = val / 10;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }

        return head.next;
    }
}