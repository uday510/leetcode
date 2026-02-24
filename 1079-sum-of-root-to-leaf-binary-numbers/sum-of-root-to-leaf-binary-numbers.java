class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) return 0;

        int cur = sum * 2 + node.val;

        if (node.left == null && node.right == null) {
            return cur;
        }

        return dfs(node.left, cur) + dfs(node.right, cur);
    }

}