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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        ListNode h = new ListNode(-1, head);
        ListNode prev, cur;
        prev = h;
        cur = head;

        while (cur != null) {
            while (cur != null && set.contains(cur.val)) {
                prev.next = cur.next;
                cur = cur.next;
            }

            prev = cur;
            if (cur != null) cur = cur.next;
        }

        return h.next;
    }
}