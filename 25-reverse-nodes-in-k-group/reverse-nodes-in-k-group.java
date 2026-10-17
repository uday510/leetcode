class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curNode = head, newHead = null, tail = null;

        while (curNode != null) {
            ListNode tmp = curNode;
            int i;

            for (i = 0; i < k && tmp != null; i++) tmp = tmp.next;

            if (i < k) {
                tail.next = curNode;
                break;
            }

            ListNode rev = reverse(curNode, k);
            if (newHead == null) newHead = rev;
            if (tail != null) tail.next= rev;
            tail = curNode;
            curNode = tmp;
        }

        return newHead;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode curNode = node, prevNode = null;

        while (k-- > 0 && curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;

            curNode = nextNode;
        }

        return prevNode;
    }
}