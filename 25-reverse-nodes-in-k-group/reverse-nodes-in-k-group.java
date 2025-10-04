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
    public ListNode reverseKGroup(ListNode head, int k) {
        return dfs(head, k);
    }
    private ListNode dfs(ListNode node, int k) {
        ListNode cur = node;
        for (int i = 0; i < k; i++) {
            if (cur == null) return node;
            cur = cur.next;
        }

        ListNode prev = null;
        cur = node;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        node.next = dfs(cur, k);
        
        return prev;
    }
}