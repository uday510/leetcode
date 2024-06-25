class Solution {
    int rightVal = 0;
    public TreeNode bstToGst(TreeNode root) {
        return dfs(root);
    }
    public TreeNode dfs(TreeNode root) {
        if (root == null)
            return new TreeNode(0, null, null);
        
        
        dfs(root.right);
        
        root.val += rightVal;
        rightVal = root.val;
        
        dfs(root.left);
        
        return root;
    }
}