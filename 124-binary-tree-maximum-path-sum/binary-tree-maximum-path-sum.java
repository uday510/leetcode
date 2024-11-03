class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        int curr = left+right+node.val;
        max = Math.max(max, curr);

        return Math.max(left, right) + node.val;
    }
}