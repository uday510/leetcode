class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int nodes = lists.length;
        int interval = 1;
        while (interval < nodes) {
            for (int i = 0; i < nodes - interval; i += interval*2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return nodes > 0 ? lists[0] : null;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null  ? l1 : l2;

        return dummy.next; 
    }
}