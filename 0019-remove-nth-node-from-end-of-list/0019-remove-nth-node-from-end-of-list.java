class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int[] count = { 0 };
        return removeNthFromEndRecursive(head, n, count);
    }

    private ListNode removeNthFromEndRecursive(ListNode head, int n, int[] count) {
        if (head == null) {
            count[0] = 0;
            return null;
        }

        ListNode next = removeNthFromEndRecursive(head.next, n, count);
        count[0]++;

        if (count[0] == n ) {
            // Remove the nth node
            return next;
        }

        head.next = next;
        return head;
    }
}
