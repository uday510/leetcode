class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middleNode = getMiddleNode(head);
        ListNode head2 = middleNode.next;
        middleNode.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(head2);

        ListNode ans = doMerge(list1, list2);

        return ans;
    }
    private ListNode doMerge(ListNode p1, ListNode p2) {
        
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
        tail.next = (p1!= null) ? p1 : p2;

        return head.next;
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
}