
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || p.val == node.val || q.val == node.val) return node;

       TreeNode left = dfs(node.left, p, q);
       TreeNode right = dfs(node.right, p, q);
       
       if (left == null) return right;
       if (right == null) return left;
       return node;
    }
}