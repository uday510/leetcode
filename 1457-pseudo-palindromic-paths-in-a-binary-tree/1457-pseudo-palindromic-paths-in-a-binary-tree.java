class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, new int[10]);
    }
    public int dfs(TreeNode node, int[] pairs) {
        if (node == null) return 0;

        pairs[node.val]++;

        if (node.left == null && node.right == null) {
            int oddCnt = 0;

            for (int cnt : pairs) {
                oddCnt += (cnt & 1) == 1 ? 1 : 0;
            }
            pairs[node.val]--;
            return (oddCnt > 1) ? 0 : 1;
        }

        int total =  dfs(node.right, pairs) + dfs(node.left, pairs);

        pairs[node.val]--;
        return total;
    }
}