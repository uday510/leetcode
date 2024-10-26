class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int height) {
        if (node == null)   
            return height;

        return Math.max(dfs(node.left, height+1), dfs(node.right, height+1));
    }
}