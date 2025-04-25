class Solution {
    public ListNode sortLinkedList(ListNode head) {
        ListNode currNode = head;
        ListNode posHead = null, posTail = null;
        ListNode negHead = null, negTail = null;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = null;

            if (currNode.val > -1) {
                if (posHead == null) {
                    posHead = posTail = currNode;
                } else {
                    posTail.next = currNode;
                    posTail = posTail.next;
                }
            } else {
                if (negHead == null) {
                    negHead = negTail = currNode;
                } else {
                    currNode.next = negHead;
                    negHead = currNode;
                }
            }

            currNode = nextNode;
        }

        if (negTail != null) negTail.next = posHead;
        return negHead != null ? negHead : posHead;
    }
}