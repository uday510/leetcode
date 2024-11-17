class Solution {
    public ListNode sortList(ListNode head) {
        
        ListNode sortedList = sort(head);

        return sortedList;
    }
    private ListNode sort(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode middleNode = getMiddleNode(node);
        ListNode nextNode = middleNode.next;
        middleNode.next = null;

        ListNode p1 = sort(node);
        ListNode p2 = sort(nextNode);

        ListNode p = merge(p1, p2);

        return p;
    }
    private ListNode getMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode p1 = node1;
        ListNode p2 = node2;
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        tail.next = (p1 == null) ? p2 : p1;

        return head.next;
    }
}