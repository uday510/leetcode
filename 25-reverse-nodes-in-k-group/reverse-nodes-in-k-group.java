class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return dfs(head, k);
    }
    private ListNode dfs(ListNode node, int k) {
        ListNode curr = node;
        for (int i = 0; i < k; ++i) {
            if (curr == null) {
                return node;
            }
            
            curr = curr.next;
        }
        System.out.println(node.val);

        ListNode prev = null;
        curr = node;
        
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