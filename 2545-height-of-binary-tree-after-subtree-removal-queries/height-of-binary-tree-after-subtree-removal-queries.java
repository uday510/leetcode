class Solution {
    int[] heights = new int[100001];
    int maxHeight = 0;
    public int[] treeQueries(TreeNode root, int[] queries) {
        preorder(root, 0);
        maxHeight = 0;
        postorder(root, 0);

        int n = queries.length;
        int[] res = new int[n];
        for (int idx = 0; idx < n; ++idx) {
            res[idx] = heights[queries[idx]];
        }
        return res;
    }
    private void preorder(TreeNode node, int currHeight) {
        if (node == null)   
            return;

        heights[node.val] = maxHeight;

        maxHeight = Math.max(currHeight, maxHeight);

        preorder(node.left, currHeight+1);
        preorder(node.right, currHeight+1);
    }
    private void postorder(TreeNode node, int currHeight) {
        if (node == null)
            return;

        heights[node.val] = Math.max(heights[node.val], maxHeight);

        maxHeight = Math.max(currHeight, maxHeight);

        postorder(node.right, currHeight+1);
        postorder(node.left, currHeight+1);
    }
}