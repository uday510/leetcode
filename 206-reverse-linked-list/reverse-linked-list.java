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
    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) 
            return node;
        
        
        ListNode head = reverseList(node.next);
        node.next.next = node;
        node.next = null;

        return head;
    }
}


/**


1 -> 2 -> 3 -> null


rev(1)

    h = rev(2)


rev(2)

    h = rev(3)


rev(3)


 */