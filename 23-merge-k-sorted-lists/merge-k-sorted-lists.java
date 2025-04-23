class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return dfs(0, lists.length - 1, lists);
    }

    private ListNode dfs(int i, int j, ListNode[] lists) {
        if (i > j) return null;
        if (i == j) return lists[i];

        int mid = (i + j) >> 1;
        ListNode left = dfs(i, mid, lists);
        ListNode right = dfs(mid + 1, j, lists);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        tail.next = (left == null) ? right : left;

        return head.next;
    }
}