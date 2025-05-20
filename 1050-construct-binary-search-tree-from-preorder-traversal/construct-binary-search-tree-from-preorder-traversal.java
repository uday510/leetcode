class Solution {

    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(-(int)1e9 , (int)1e9, preorder);
    }

    private TreeNode dfs(int low, int high, int[] preorder) {
        if (idx >= preorder.length) return null;
        int val = preorder[idx];
        if (val < low || val > high) return null;

        TreeNode root = new TreeNode(val);
        idx++;
        root.left = dfs(low, val, preorder);
        root.right = dfs(val, high, preorder);

        return root; 
    }
}