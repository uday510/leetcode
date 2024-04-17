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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new StringBuilder());
    }
    public String dfs(TreeNode node, StringBuilder sb) {
        
        sb.append((char)('a' + node.val));
        
        if (node.left == null && node.right == null) {
            return sb.reverse().toString();
        }
        
        String left = node.left != null ? dfs(node.left, new StringBuilder(sb)) : null;
        
        String right = node.right != null ? dfs(node.right, new StringBuilder(sb)) : null;
        
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        
        return left.compareTo(right) < 0 ? left : right;
        
    }
}