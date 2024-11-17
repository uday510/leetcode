class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return dfs(0, nums.length - 1, nums);
    }
    private TreeNode dfs(int i, int j, int[] nums) {
        if (i > j) {
            return null;
        }

        int index = (i + j) >> 1;
        TreeNode node = new TreeNode(nums[index]);

        node.left = dfs(i, index - 1, nums);
        node.right = dfs(index + 1, j, nums);

        return node;
    }
}