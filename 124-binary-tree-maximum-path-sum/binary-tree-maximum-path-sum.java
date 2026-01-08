class Solution {

    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = -(int) 1e9;

        dfs(root);

        return maxPathSum;    
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = Math.max(dfs(node.left), 0);
        int r = Math.max(dfs(node.right), 0);

        maxPathSum = Math.max(maxPathSum, l + r + node.val);

        return Math.max(l, r) + node.val;
    }
}