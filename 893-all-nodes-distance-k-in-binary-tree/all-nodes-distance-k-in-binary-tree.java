class Solution {

    Map<TreeNode, TreeNode> parentMap;
    Set<TreeNode> visited;
    List<Integer> kDistanceNodes;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        visited = new HashSet<>();
        kDistanceNodes = new ArrayList<>();

        assignParent(root, null);
        dfs(target, k);
        return kDistanceNodes;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || !visited.add(node)) return;

        if (k == 0) {
            kDistanceNodes.add(node.val);
            return;
        }

        dfs(parentMap.get(node), k - 1);
        dfs(node.left, k - 1);
        dfs(node.right, k - 1);
    }

    private void assignParent(TreeNode node, TreeNode parent) {
        if (node == null) return;

        parentMap.put(node, parent);
        assignParent(node.left, node);
        assignParent(node.right, node);
    }
}