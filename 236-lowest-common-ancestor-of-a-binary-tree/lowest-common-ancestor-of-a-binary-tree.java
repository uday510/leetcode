/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node.val == p.val || node.val == q.val) return node;

        TreeNode l = dfs(node.left, p, q);
        TreeNode r = dfs(node.right, p, q);

        if (l == null) return r;
        if (r == null) return l;

        return node;
    }
}