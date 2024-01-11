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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    public int dfs(TreeNode node, int min, int max) {
    if (node == null) return (min - max)*-1;

    min = Math.min(min, node.val);
    max = Math.max(max, node.val);
    int right = dfs(node.right, min, max);
    int left = dfs(node.left, min, max);

    return Math.max(left, right);
    }
}