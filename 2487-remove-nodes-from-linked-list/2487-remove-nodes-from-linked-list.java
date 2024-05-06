class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;

        ListNode reversedHead = reverseList(head);
        ListNode filteredListHead = filterNodes(reversedHead);
        return reverseList(filteredListHead);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    private ListNode filterNodes(ListNode head) {
        ListNode newHead = new ListNode(); 
        ListNode newTail = newHead;
        int maxSoFar = -1;

        for (ListNode currNode = head; currNode != null; currNode = currNode.next) {
            if (currNode.val >= maxSoFar) {
                maxSoFar = currNode.val;
                newTail.next = new ListNode(currNode.val); 
                newTail = newTail.next;
            }
        }

        return newHead.next;
    }
}
