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
    Map<Integer, Integer> map;
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preIndex = 0;
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }

        return dfs(0, preorder.length - 1, preorder);
    }
    private TreeNode dfs(int leftIdx, int rightIdx, int[] preorder) {
        if (leftIdx > rightIdx) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        root.left = dfs(leftIdx, map.get(root.val) - 1, preorder);
        root.right = dfs(map.get(root.val) + 1, rightIdx, preorder);

        return root;
    }
}