class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return dfs(head, k);
    }
    private ListNode dfs(ListNode node, int k) {
        if (node == null) return null;
        
        ListNode current = node;
        for (int i = 0; i < k; i++) {
            if (current == null) return node;
            current = current.next;
        }
        
        ListNode prev = null;
        ListNode curr = node;
        
        for (int i = 0; i < k; ++i) {
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            
            curr = next;
        }
        
        node.next = dfs(curr, k);
        
        return prev;
    }
}