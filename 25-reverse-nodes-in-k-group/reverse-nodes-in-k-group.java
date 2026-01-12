class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curNode = head, newHead = null, tail = null;

        while (curNode != null) {
            ListNode ptr = curNode;
            int i;

            for (i = 0; i < k && ptr != null; i++) {
                ptr = ptr.next;
            }

            if (i == k) {
                ListNode reversedHead = reverse(curNode, k);
                if (newHead == null) newHead = reversedHead;
                if (tail != null) tail.next = reversedHead;
                tail = curNode;
            } else {
                if (tail != null) tail.next = curNode;
                break;
            }

            curNode = ptr;
        }


        return newHead;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode curNode = node, prevNode = null;

        while (k-- > 0 && curNode != null) {
            ListNode nxtNode = curNode.next;
            
            curNode.next = prevNode;
            prevNode = curNode;

            curNode = nxtNode;
        }

        return prevNode;
    }
}