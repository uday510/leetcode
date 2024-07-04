/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        
        ListNode currNode = head.next;
        
        int val = 0;
        while (currNode != null) {            
            
            while (currNode.val != 0) {
                val += currNode.val;
                currNode = currNode.next;
            }
            
            if (currNode.val == 0) {
                tail.next = new ListNode(val);
                tail = tail.next;
                val -= val;
            }
            
            currNode = currNode.next;
        }
        
        return newHead.next;  
    }
}