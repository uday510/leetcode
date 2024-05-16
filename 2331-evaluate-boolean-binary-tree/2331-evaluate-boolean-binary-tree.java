class Solution {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }
    public boolean dfs(TreeNode node) {
        if (node == null) return true;
    
        if (node.val == 2) {
            return dfs(node.left) || dfs(node.right);
        } else if (node.val == 3) {
            return dfs(node.left) && dfs(node.right);
        }
        
        return node.val == 1;
    }
}