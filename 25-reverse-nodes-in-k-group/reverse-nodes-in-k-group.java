class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curNode = head, newHead = null, tail = null;

        while (curNode != null) {
            ListNode tmp = curNode;
            int i;

            for (i = 0; i < k && tmp != null; i++) {
                tmp = tmp.next;
            }


        /**

            2 -> 1 ->
            4 -> 3 -> 

            head 
            2 -> 1 -> 4 -> 3 -> tail

         */

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