class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fastNode = head;
        
        int idx = 1;
        
        while (idx++ <= n) {
            fastNode = fastNode.next;
        }
        
        if (fastNode == null) 
            return head.next;
        
        System.out.println(fastNode.val);
        
        ListNode slowNode = head;
        
        while (fastNode.next != null) {
             slowNode = slowNode.next;
             fastNode = fastNode.next;
        }
        
        slowNode.next = slowNode.next.next;
        
        return head;
        
    }
}