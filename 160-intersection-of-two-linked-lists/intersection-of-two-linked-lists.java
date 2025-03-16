public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> seen = new HashSet<>();

        ListNode currNode = headA;
        while (currNode != null) {
            seen.add(currNode);
            currNode = currNode.next;
        }

        currNode = headB;
        while (currNode != null) {
            if (!seen.add(currNode)) return currNode;
            currNode = currNode.next;
        }
        return null;
    }
}