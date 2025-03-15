class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return dfs(0, lists.length - 1, lists);
    }
    private ListNode dfs(int st, int en, ListNode[] lists) {
        if (st > en) return null;
        if (st == en) return lists[st];
        int mid = (st + en) >> 1;
        ListNode left = dfs(st, mid, lists);
        ListNode right = dfs(mid + 1, en, lists);
        ListNode merged = merge(left, right);
        return merged;
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