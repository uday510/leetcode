class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(-1);
        ListNode afterHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                before.next = curr;
                before = before.next;
            } else {
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }

        before.next = afterHead.next;
        after.next = null;

        return beforeHead.next;
    }
}