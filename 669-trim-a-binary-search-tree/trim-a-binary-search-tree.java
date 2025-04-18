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

    int low;
    int high;

    public TreeNode trimBST(TreeNode root, int low, int high) {

        this.low = low;
        this.high = high;

        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        node.left = dfs(node.left);
        node.right = dfs(node.right);

        if (node.val < low) {
            System.out.println(node.val);
            return node.right;
            // System.out.println("LEFT" + " " + node.left);
        } else if(node.val > high) {
        //    node.right = node.right != null ? node.right.left : null;
           return node.left;
        }

        return node;
    }
}


/**
0 , 1, 2

 */