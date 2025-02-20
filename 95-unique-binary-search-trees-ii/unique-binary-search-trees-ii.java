class Solution {
    public List<TreeNode> generateTrees(int n) {
       return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        if (left > right) {
            return Collections.singletonList(null);
        }

        if (left == right) {
            return Collections.singletonList(new TreeNode(left));
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
        return list;
    }
}