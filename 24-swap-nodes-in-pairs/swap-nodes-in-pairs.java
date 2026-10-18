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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode prev = tmp;
        ListNode cur = tmp.next;
        
        while (cur != null && cur.next != null) {
            ListNode nxt = cur.next;

            cur.next = nxt.next;
            nxt.next = cur;
            prev.next = nxt;
            prev = cur;

            cur = cur.next;
        } 

        return tmp.next;
    }
}

/**

0 - 2 - 1 - 5 - 3

1 -> 3
2 -> 1

0 -> 2 -> 1 -> 3
tmp
0 - 1 - 2 - 3  - 5
        nxt

    cur.next = nxt.next
    nxt.next = cur;
    prev.next = nxt;
    
    prev = cur
    cur = cur.next

    
    p      c
    0 -->  1  -->   2  --->  3   -->    4
                    n

        1 -> 3
    0 -> 2 -> 1            

 */