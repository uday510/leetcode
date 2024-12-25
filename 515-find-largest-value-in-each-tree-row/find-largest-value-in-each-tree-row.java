class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();

        dfs(root, 0);
        
        return result;
    }
    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        int value = node.val;
        if (result.size() == level) {
            result.add(value);
        }

        result.set(level, Math.max(result.get(level), value));

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}