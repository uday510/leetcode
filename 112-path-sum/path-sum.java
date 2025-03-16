
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(targetSum, root);
    }

    private boolean dfs(int currSum, TreeNode node) {
        if (node == null) return false;
        
        currSum -= node.val;
        if (node.left == null && node.right == null) 
            return currSum == 0;

        return dfs(currSum, node.left) || dfs(currSum, node.right);
    }
}