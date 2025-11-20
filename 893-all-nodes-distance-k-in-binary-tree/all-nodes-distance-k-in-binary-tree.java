class Solution {

    Map<TreeNode, TreeNode> parentMap;
    Set<TreeNode> vis;
    List<Integer> nodesDistanceK;
    TreeNode target;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        vis = new HashSet<>();
        nodesDistanceK = new ArrayList<>();
        this.target = target;

        assignParent(root);
        dfs(target, k);
        
        return nodesDistanceK;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || !vis.add(node)) return;

        if (k == 0) nodesDistanceK.add(node.val);
        
        dfs(parentMap.get(node), k - 1);
        dfs(node.left, k - 1);
        dfs(node.right, k - 1);
        
    }
    
    private void assignParent(TreeNode node) {
        if (node == null) return;

        add(node.left, node);
        add(node.right, node);

        assignParent(node.left);
        assignParent(node.right);
    }

    private void add(TreeNode node, TreeNode parent) {
        if (node != null) parentMap.put(node, parent);
    }
}