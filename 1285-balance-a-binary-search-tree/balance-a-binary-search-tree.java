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

        private List<Integer> list;

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        
        return bs(0, list.size() - 1);
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    private TreeNode bs(int l, int r) {
        if (l > r) return null;

        int m = (l + r) >> 1;

        TreeNode node = new TreeNode(list.get(m), bs(l, m - 1), bs(m + 1, r));

        return node;
    }
}