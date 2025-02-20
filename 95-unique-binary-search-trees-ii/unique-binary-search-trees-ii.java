class Solution {
    Map<String, List<TreeNode>> dp;
    public List<TreeNode> generateTrees(int n) {
        dp = new HashMap<>();
       return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        if (left > right) {
            return Collections.singletonList(null);
        }

        if (left == right) {
            return Collections.singletonList(new TreeNode(left));
        }

        String key = left + "-" + right;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        var list = new ArrayList<TreeNode>();

        for (int idx = left; idx <= right; ++idx) {
            List<TreeNode> leftSubTree = dfs(left, idx - 1);
            List<TreeNode> rightSubTree = dfs(idx + 1, right);

            for (var leftNode : leftSubTree) {
                for (var rightNode : rightSubTree) {
                    TreeNode rootNode = new TreeNode(idx, leftNode, rightNode);

                    list.add(rootNode);
                }
            }
        }
        
        dp.put(key, list);
        
        return list;
    }
}