public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null && p2.next != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1 == p2;
    }
}