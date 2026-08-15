class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> vis = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        assign(root, map);
        dfs(t, k, vis, map, list);
        return list;
    }

    private void dfs(TreeNode node, int k, Set<TreeNode> vis, 
    Map<TreeNode, TreeNode> map, List<Integer> res) {

        if (node == null || vis.contains(node)) 
            return;
        
        if (k == 0) {
            res.add(node.val);
            return;
        }

        vis.add(node);

        dfs(map.get(node), k - 1, vis, map, res);
        dfs(node.left, k - 1, vis, map, res);
        dfs(node.right, k - 1, vis, map, res);

    }

    private void assign(
        TreeNode parent,
        Map<TreeNode, TreeNode> map
    ) {

        if (parent == null) return;

        if (parent.left != null) map.put(parent.left, parent);
        if (parent.right != null) map.put(parent.right, parent);

        assign(parent.left, map);
        assign(parent.right, map);
    }
}