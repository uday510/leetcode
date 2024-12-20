class Solution {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        dfs(node.left);
        dfs(node.right);

        return node;
    }
}