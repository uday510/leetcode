class Solution {
    private List<TreeNode>[][] dp;
    public List<TreeNode> generateTrees(int n) {
        dp = new ArrayList[n + 1][n + 1];

        return dfs(1, n);
    }
    private List<TreeNode> dfs(int left, int right) {
        if (left > right) {
            return Collections.singletonList(null);
        }

        if (left == right) {
            return Collections.singletonList(new TreeNode(right));
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        var trees = new ArrayList<TreeNode>();

        for (int idx = left; idx <= right; ++idx) {

            var leftSubTrees = dfs(left, idx - 1);
            var rightSubTrees = dfs(idx + 1, right);

            for (var leftSubTree : leftSubTrees) {
                for (var rightSubTree : rightSubTrees) {
                    var tree =  new TreeNode(idx, leftSubTree, rightSubTree);
                    trees.add(tree);
                }
            }
        }

        return trees;
    }
}