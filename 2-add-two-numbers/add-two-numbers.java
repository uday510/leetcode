class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode currNode = head;
        int rem = 0;

        while (p1 != null || p2 != null || rem != 0) {
            int val = rem;
            val += p1 != null ? p1.val : 0;
            val += p2 != null ? p2.val : 0;

            ListNode node = new ListNode(val % 10);

            currNode.next = node;

            currNode = currNode.next;

            rem = val / 10;

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }

        return head.next; 
    }
}