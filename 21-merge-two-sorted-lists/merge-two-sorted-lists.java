class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode currNode = new ListNode(-1);
        ListNode head = currNode;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                currNode.next = p1;
                p1 = p1.next;
            } else {
                currNode.next = p2;
                p2 = p2.next;
            }
            currNode = currNode.next;
        }

        while (p1 != null) {
             currNode.next = p1;
             p1 = p1.next;
             currNode = currNode.next;
        }

        currNode.next = p2;

        return head.next;
    }
}