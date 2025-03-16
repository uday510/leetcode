class Solution {
    List<List<Integer>> paths;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return paths;
    }

    private void dfs(TreeNode node, int curr, List<Integer> path) {
        if (node == null) return;

        curr -= node.val;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (curr == 0 && path.size() > 0) {
                paths.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        dfs(node.left, curr, path);
        dfs(node.right, curr, path);
        path.remove(path.size() - 1);
    }
}