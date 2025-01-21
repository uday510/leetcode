class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return dfs(0, lists.length - 1, lists);
    }

    private ListNode dfs(int i, int j, ListNode[] lists) {
        if (i > j) {
            return null;
        }

        if (i == j) {
            return lists[i];
        }

        int midIdx = (i + j) >> 1;

        ListNode left = dfs(i, midIdx, lists);
        ListNode right = dfs(midIdx + 1, j, lists);

        ListNode merged = merge(left, right);

        return merged;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode p1 = node1;
        ListNode p2 = node2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }

            tail = tail.next;
        }

        tail.next = (p1 == null) ? p2 : p1;

        return dummy.next;
    }
}