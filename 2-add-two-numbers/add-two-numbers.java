class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(-1);
        ListNode cur = h, p1 = l1, p2 = l2;
        int c = 0;

        while (p1 != null || p2 != null || c != 0) {
            int sum = getSum(p1, p2, c);

            ListNode n = new ListNode(sum % 10);
            cur.next = n;
            cur = n;

            c = sum / 10;

            p1 = getNextNode(p1);
            p2 = getNextNode(p2);
        }

        return h.next;
    }

    private int getSum(ListNode p1, ListNode p2, int c) {
        int sum = c;

        sum += p1 != null ? p1.val : 0;
        sum += p2 != null ? p2.val : 0;

        return sum;
    }

    private ListNode getNextNode(ListNode p) {
        return p == null ? null : p.next;
    }
}