class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        if (n1 == null && n2 == null) return true;

        return n1.val == n2.val &&
                dfs(n1.left, n2.right) &&
                dfs(n2.right, n1.left);
    }
}