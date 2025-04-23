class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = -(int) 1e9;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        int curr = node.val + left + right;
        max = Math.max(curr, max);

        return node.val + Math.max(left, right);
    }
}