class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode newHead = null, tail = null, cur = head;

        while (cur != null) {
            ListNode ptr = cur;
            int cnt;

            for (cnt = 0; cnt < k && ptr != null; cnt++) {
                ptr = ptr.next;
            }

            if (cnt == k) {
                ListNode reversedHead = reverse(cur, k);
                if (newHead == null) newHead = reversedHead;
                if (tail != null) tail.next = reversedHead;
                tail = cur;
                cur = ptr;
            } else {
                if (tail != null) tail.next = cur;
                break;
            }
        }

        return newHead == null ? head : newHead;
    }

    private ListNode reverse(ListNode cur, int k) {
        ListNode prev = null;

        while (k-- > 0) {
            ListNode nxt = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = nxt;
        }

        return prev;
    }
}