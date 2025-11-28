class Solution {

    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = -(int) 1e9;

        dfs(root);

        return maxPathSum;    
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;


        int l = dfs(node.left);
        int r = dfs(node.right);


        maxPathSum = Math.max(maxPathSum, l + r + node.val);

        return Math.max(Math.max(l, r) + node.val, 0);
    }
}