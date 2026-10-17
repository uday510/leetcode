/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int mx;
    public int maxPathSum(TreeNode root) {
        mx = -(int) 1e9;
        dfs(root);
        return mx;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = Math.max(dfs(node.left), 0);
        int r = Math.max(dfs(node.right), 0);

        mx = Math.max(mx, l + r + node.val);

        return Math.max(l, r) + node.val;
    }
}