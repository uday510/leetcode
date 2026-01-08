/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        return dfs(0, lists.length - 1, lists);
    }

    private ListNode dfs(int l, int r, ListNode[] lists) {
        if (l > r) return null;
        if (l == r) return lists[l];

        int m = (l + r) >> 1;
        ListNode left = dfs(l, m, lists);
        ListNode right = dfs(m + 1, r, lists);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode l = left, r = right;

        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }

            cur = cur.next;
        }

        cur.next = l == null ? r : l;

        return head.next; 
    }
}