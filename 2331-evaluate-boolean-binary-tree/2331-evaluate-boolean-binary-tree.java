class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) return true;
    
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else if (root.val == 3) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        
        return root.val == 1;
    }
}