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
    public ListNode rotateRight(ListNode h, int k) {

        if (h == null || k == 0) return h;

        ListNode oH = h;
        ListNode oT = h;
        int l = 1;

        while (oT.next != null) {
            oT = oT.next;
            l++;
        }

        if (Math.abs(k) % l == 0) return oH;

        int p = k > 0 ? l - (k % l) : k;

        ListNode nT = h;

        for (int i = 1; i < p && nT != null; i++) {
            nT = nT.next;
        }

        ListNode nH = nT.next;
        nT.next = null;
        oT.next = h;

        return nH;
    }

}