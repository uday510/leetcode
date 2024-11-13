class Solution {
    int kth = -1;
    int level = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return kth;
    }
    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        dfs(node.left, k);
        ++level;
        if (level == k) {
            kth = node.val;
            return;
        }
        dfs(node.right, k);
    }
}