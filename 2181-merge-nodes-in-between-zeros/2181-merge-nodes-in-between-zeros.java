class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode currNode = head.next;
        
        int currSum = 0;
        while (currNode != null) {
            if (currNode.val != 0) {
                currSum += currNode.val;
            } else {
                tail.next = new ListNode(currSum);
                tail = tail.next;
                currSum -= currSum;
            }
            currNode = currNode.next;
        }
        
        return newHead.next;
    }
}