class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        dfs(root, val);

        return root;
    }

    private void dfs(TreeNode node, int val) {
        if (node == null) {
            return;
        }

        if (node.val <= val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            }
            dfs(node.right,  val);
        } else {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }
            dfs(node.left, val);
        }
    }
}