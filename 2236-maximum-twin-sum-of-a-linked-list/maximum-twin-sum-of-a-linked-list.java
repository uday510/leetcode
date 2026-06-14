class Solution {
    public int pairSum(ListNode head) {
        var p1 = head;
        var p2 = ok(head);

        int mx = -1;
        while (p1 != null && p2 != null) {
            mx = Math.max(mx, p1.val + p2.val);
            p1 = p1.next; p2 = p2.next;
        }

        return mx;
    }

    private ListNode ok(ListNode head) {
        int n = 0;
        ListNode cur = head;

        while (cur != null) {
            n++;
            cur = cur.next;
        }

        int i = 0;
        cur = head;
        while (i < n / 2 - 1&& cur != null) {
            cur = cur.next;
            i++;
        }

        ListNode nxt = cur.next;
        cur.next = null;

        ListNode prev = null;
        cur = nxt;
        
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;

            cur = nxt;
        }

        return prev;
    }
}