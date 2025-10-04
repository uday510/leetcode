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
        ListNode newHead = null, tail = null;
        ListNode cur = head;

        while (cur != null) {
            int cnt = 0;
            ListNode ptr = cur;
            while (cnt < k && ptr != null) {
                ptr = ptr.next;
                cnt++;
            }

            if (cnt == k) {
                ListNode revHead = reverse(cur, k);
                if (newHead == null) newHead = revHead;

                if (tail != null) tail.next = revHead;

                tail = cur;
                cur = ptr;
            } else {
                if (tail != null) tail.next = cur;
                break;
            }
        }

        return newHead == null ? head : newHead;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode prev = null, cur = node;

        while (k > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            
            k--;
        }

        return prev;
    }
}