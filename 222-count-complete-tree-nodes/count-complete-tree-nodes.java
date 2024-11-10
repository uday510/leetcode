class Solution {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getLeftHeight(node.left);
        int right = getRightHeight(node.right);

        if (left == right) {
            return (1 << left) - 1;
        }

        return 1 + dfs(node.left) + dfs(node.right);
    }
    private int getLeftHeight(TreeNode node) {
        int cnt = 1;

        while (node != null) {
            ++cnt;
            node = node.left;
        }

        return cnt;
    }
    private int getRightHeight(TreeNode node) {
        int cnt = 1;

        while (node != null) {
            ++cnt;
            node = node.right;
        }

        return cnt;
    }
}