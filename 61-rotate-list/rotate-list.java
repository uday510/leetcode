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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode listTail = head;
        int length = 1;

        while (listTail.next != null) {
            listTail = listTail.next;
            length++;
        }

        int offset = Math.abs(k) % length;
        if (offset == 0) return head;

        int newTailPosition = length - offset;
        ListNode newTail = head;

        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;

        return newHead;
        
    }
}