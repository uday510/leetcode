class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> vis = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        assignNodes(root, map);
        dfs(target, k, vis, map, res);

        return res;
    }

    private void dfs(TreeNode node, 
    int k, Set<TreeNode> vis, 
    Map<TreeNode, TreeNode> map, List<Integer> res) {

        if (node == null || vis.contains(node)) return;

        vis.add(node);
        if (k == 0) {
            res.add(node.val);
            return;
        }

        dfs(map.get(node), k - 1, vis, map, res);
        dfs(node.left, k - 1, vis, map, res);
        dfs(node.right, k - 1, vis, map, res);
    }

    private void assignNodes(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node == null) return;

        addNode(node.left, node, map);
        addNode(node.right, node, map);

        assignNodes(node.left, map);
        assignNodes(node.right, map);
    }

    private void addNode(TreeNode child, TreeNode parent, Map<TreeNode, TreeNode> map) { 
        if (child == null) return;       
        map.put(child, parent);
    }
}