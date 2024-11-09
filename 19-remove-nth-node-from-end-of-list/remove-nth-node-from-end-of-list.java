class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode second = head;

        for (int i = 1; i <= n; ++i) {
            second = second.next;
        }

        if (second == null) {
            return head.next;
        }

        ListNode first = head;
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;

        return head;
    }
}