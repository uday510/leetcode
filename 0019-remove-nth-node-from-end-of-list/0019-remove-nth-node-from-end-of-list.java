class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int[] count = { 0 };
        return dfs(head, n, count);
    }

    private ListNode dfs(ListNode head, int n, int[] count) {
        if (head == null) {
            count[0] = 0;
            return null;
        }

        ListNode next = dfs(head.next, n, count);
        count[0]++;

        if (count[0] == n) {
            return next;
        }

        head.next = next;
        return head;
    }
}
