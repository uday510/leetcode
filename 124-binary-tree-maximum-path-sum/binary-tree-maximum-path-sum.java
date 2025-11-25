class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = -(int) 1e9;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        max = Math.max(max, l + r + node.val);

        return Math.max(0, Math.max(l, r) + node.val);
    }
}