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
    public TreeNode invertTree(TreeNode node) {
        if (node == null) return null;

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invertTree(node.left);
        invertTree(node.right);
        
        return node;
    }
}