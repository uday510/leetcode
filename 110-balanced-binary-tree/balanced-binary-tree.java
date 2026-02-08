class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int lH = dfs(root.left);
        if (lH == -1) return -1;

        int rH = dfs(root.right);
        if (rH == -1) return -1;

        if (Math.abs(lH - rH) > 1) return -1;

        return 1 + Math.max(lH, rH);
    }

}