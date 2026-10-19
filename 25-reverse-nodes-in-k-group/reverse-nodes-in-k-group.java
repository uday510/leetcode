class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode cur = head;
        ListNode tail = null;

        while (cur != null) {
            ListNode tmp = cur;
            int i = 0;

            while (i < k && tmp != null) { i++; tmp = tmp.next; }
            
            if (i == k) {
                ListNode rev = reverse(cur, k);
                if (newHead == null) newHead = rev;
                if (tail != null) tail.next = rev;
                tail = cur;
            } else {
                if (tail != null) tail.next = cur;
                break;
            }

            cur = tmp;
        }

        return newHead;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode cur = node, prev = null;

        while (cur != null && k-- > 0) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        return prev;
    }
}

/**

1 -> 2 -> 3  | 4 -> 5 -> 6

          tail  
3 -> 2 -> 1     6 -> 5 -> 4

 */