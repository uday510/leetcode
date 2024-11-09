class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode oldHead = head;
        ListNode oldTail = oldHead;
        int len = 1;

        while (oldTail.next != null) {
            oldTail = oldTail.next;
            ++len;
        }

        if (Math.abs(k) % len == 0) return head;
        int pos = k > 0 ? len - Math.abs(k) % len : k;
        ListNode newTail = head;

        for (int i = 1; i < pos; ++i) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        oldTail.next = oldHead;

        return newHead;
    }
}