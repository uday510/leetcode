class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        ListNode prevNode = null, curNode = head;
        int curIdx = 1, firstIdx = -1, prevIdx = -1;
        int mn = Integer.MAX_VALUE;

        while (curNode != null && curNode.next != null) {
            if (isCriticalPoint(prevNode, curNode)) {
                if (firstIdx == -1) firstIdx = curIdx;
                else mn = Math.min(mn, curIdx - prevIdx);
                prevIdx = curIdx;
            }

            prevNode = curNode;
            curNode = curNode.next;
            curIdx++;
        }

        if (mn == Integer.MAX_VALUE) return new int[] {-1, -1};

        return new int[] {mn, prevIdx - firstIdx};
    }

    private boolean isCriticalPoint(ListNode prev, ListNode cur) {
        if (prev == null || cur == null || cur.next == null)
            return false;
        
        return cur.val < prev.val && cur.val < cur.next.val ||
               cur.val > prev.val && cur.val > cur.next.val; 
    }
}

/**

1   2   3   4   5   6   7
5 - 3 - 1 - 2 - 5 - 1 - 2

3   5   6

*/