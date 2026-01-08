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
    public void flatten(TreeNode root) {
        
        TreeNode cur = root;

        while (cur != null) {

            if (cur.left != null) {
                TreeNode rMost = cur.left;
                while (rMost.right != null) {
                    rMost = rMost.right;
                }

                rMost.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;
        }

        
    }
}