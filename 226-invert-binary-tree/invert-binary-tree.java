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