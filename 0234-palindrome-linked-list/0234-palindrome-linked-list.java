class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfHead = reverse(firstHalfEnd);
        
        
        while (secondHalfHead != null) {
            if (head.val != secondHalfHead.val) {
                return false;
            }
            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }
        
        return true;
    }
    
    public ListNode endOfFirstHalf(ListNode node) {
        
        ListNode fastNode = node;
        ListNode slowNode = node;
        
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        

        return slowNode;
    }
    
    public ListNode reverse(ListNode node) {
        ListNode currNode = node;
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

