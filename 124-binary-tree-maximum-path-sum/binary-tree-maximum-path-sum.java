class Solution {
    public int maxPathSum(TreeNode root) {
        
        int[] res = {- (int) 1e9 };
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) return 0;

        int l = Math.max(dfs(node.left, res), 0);
        int r = Math.max(dfs(node.right, res), 0);

        res[0] = Math.max(res[0], l + r + node.val);

        return Math.max(l, r) + node.val;
    }
}