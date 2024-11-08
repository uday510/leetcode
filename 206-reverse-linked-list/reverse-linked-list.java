class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;

        while (currNode != null) {
            ListNode nextNode = currNode.next;

            currNode.next = prevNode;
            prevNode = currNode;

            currNode = nextNode;
        }

        return prevNode;
    }
}