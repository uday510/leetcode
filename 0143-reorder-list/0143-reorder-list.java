class Solution {
    
    public void reorderList(ListNode head) {
        ListNode firstHalfHead = head;
        ListNode secondHalfHead = splitLinkedList(head);
        ListNode reverseSecondHalf = reverse(secondHalfHead);

        ListNode l1 = firstHalfHead;
        ListNode l2 = reverseSecondHalf;

        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
        return;
    }
    public ListNode splitLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfHead = slow.next;
        slow.next = null;
        return secondHalfHead;

    }
    public ListNode reverse(ListNode head) {
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
}