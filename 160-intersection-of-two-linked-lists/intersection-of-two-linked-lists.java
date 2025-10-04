public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> seen = new HashSet<>();
        ListNode p1 = headA, p2 = headB;

        while(p1 != null) {
            seen.add(p1);
            p1 = p1.next;
        }

        while (p2 != null) {
            if (!seen.add(p2)) return p2;
            p2 = p2.next;
        }

        return null;
    }
}