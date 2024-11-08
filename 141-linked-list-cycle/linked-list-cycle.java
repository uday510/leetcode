public class Solution {
    public boolean hasCycle(ListNode head) {
        var seen = new HashSet<ListNode>();
        ListNode currNode = head;

        while (currNode != null && !seen.contains(currNode)) {
            seen.add(currNode);
            currNode = currNode.next;
        }

        return currNode != null;
    }
}