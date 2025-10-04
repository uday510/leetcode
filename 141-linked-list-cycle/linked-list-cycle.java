/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       Set<ListNode> seen = new HashSet<>();
       ListNode c = head;

       while (c != null) {
            if (!seen.add(c)) return true;
            c = c.next;
       }

       return false;
    }
}