class Solution {
    Map<TreeNode, TreeNode> map;
    List<Integer> list;
    Set<TreeNode> vis;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        list = new ArrayList<>();
        vis = new HashSet<>();

        applyParent(root);

        dfs(target, k);
        return list;
    }
    
    private void applyParent(TreeNode node) {
        if (node == null) return;

       map.put(node.left, node);
       map.put(node.right, node);

       applyParent(node.left);
       applyParent(node.right);
    }
    
    private void dfs(TreeNode node, int dist) {
        if (node == null || !vis.add(node)) return;
        
        if (dist == 0) {
            list.add(node.val);
            return;
        }
        
        dfs(node.left, dist - 1);
        dfs(node.right, dist - 1);
        dfs(map.get(node), dist - 1);
    }
}