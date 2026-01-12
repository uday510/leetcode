class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null, tail = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode ptr = curNode;
            int cnt;

            for (cnt = 0; cnt < k && ptr != null; cnt++) {
                ptr = ptr.next;
            }

            if (cnt == k) {
                ListNode reversedHead = reverse(curNode, k);
                if (newHead == null) newHead = reversedHead;
                if (tail != null) tail.next = reversedHead;
                tail = curNode;
                curNode = ptr;
            } else {
                if (tail != null) tail.next = curNode;
                break;
            }
            
        }
        
        return newHead;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode curNode = node, prevNode = null, nxtNode;

        while (k-- > 0 && curNode != null) {
            nxtNode = curNode.next;

            curNode.next = prevNode;
            prevNode = curNode;
            
            curNode = nxtNode;
        }

        return prevNode;
    }

}