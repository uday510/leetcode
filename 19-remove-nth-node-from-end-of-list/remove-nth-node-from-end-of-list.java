class Solution {
    public ListNode removeNthFromEnd(ListNode h, int n) {
        

        ListNode s = h;

        for (int i = 1; i <= n && s != null; i++) {
            s = s.next;
        }

        if (s == null) return h.next;

        ListNode f = h;

        while (s.next != null) {
            f = f.next;
            s = s.next;
        }

        f.next = f.next.next;
        return h;
    }
}