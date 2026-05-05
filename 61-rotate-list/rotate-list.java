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

        if (head == null || k == 0) return head;
        
        ListNode tail = head;
        ListNode curNode = head;
        int len = 0;

        while (curNode != null) {
            len++;
            tail = curNode;
            curNode = curNode.next;
        }


        if (k % len == 0) return head;

        int req = len - (k % len);

        curNode = head;

        for (int i = 1; i < req && curNode != null; i++) {
            curNode = curNode.next;
        }

        
        assert curNode != null;
        ListNode newHead = curNode.next;
        curNode.next = null;
        tail.next = head;
        
        return newHead;
    }

}