class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode curNode = head;
        ListNode tail = null;

        while (curNode != null) {
            ListNode tmp = curNode;
            int i = 0;

            while (i < k && tmp != null) {
                i++; tmp = tmp.next;
            }

            if (i == k) {
                 ListNode reversed = reverse(curNode, k);
                 if (newHead == null) newHead = reversed;
                 if (tail != null) tail.next = reversed;
                 tail = curNode;
            } else {
                if (tail != null) tail.next = curNode;
                break;
            }

            curNode = tmp;
        }

        return newHead;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode cur = node, prev = null;

        while (cur != null && k-- > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;

            cur = next;
        }

        return prev;
    }
}