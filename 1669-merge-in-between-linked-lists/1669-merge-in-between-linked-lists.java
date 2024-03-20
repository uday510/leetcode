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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int val = 1;
        ListNode head1 = list1;
        ListNode prev1 = head1;
        ListNode prev2 = head1;
        
        ListNode currNode = head1;
        
        while (currNode != null && val != b + 2) {
            
            if (val == a) {
                prev1 = currNode;
            }
            
            if (val == b + 1) {
                prev2 = currNode;
            }
            
            ++val;
            currNode = currNode.next;
        }
                
        prev1.next = list2;
        
        currNode = list2;
        
        while (list2.next != null) {
            list2 = list2.next;
        }
        
        list2.next = prev2.next;
        return head1;
    }
}