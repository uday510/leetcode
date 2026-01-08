class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long mn, long mx) {
        if (node == null) return true;

        if (node.val <= mn || node.val >= mx) return false;

        return dfs(node.left, mn, node.val) && dfs(node.right, node.val, mx);
    }
    
}