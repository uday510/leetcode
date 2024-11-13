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
    int min;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        min = (int) 1e9;
        dfs(root);
        return min;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

       dfs(node.left);

       if (prev != null) {
        min = Math.min(min, node.val - prev.val);
       }
       
       prev = node;

       dfs(node.right);
    }
}