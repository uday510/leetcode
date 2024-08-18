class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode prev = null;
        if (p1 == null) return p2;
        if (p2 == null) return p1;
        
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                prev = p1;
                p1 = p1.next;
            } else {
                if(prev != null) prev.next = p2;
                prev = p2;
                p2 = p2.next;
                prev.next = p1;
            }
        }
        
        if (p1 == null) prev.next = p2;
        
        return list1.val <= list2.val ? list1 : list2;
    }
}
