class Solution {

    Map<TreeNode, TreeNode> pMap;
    Set<TreeNode> vis;
    List<Integer> dK;
    TreeNode t;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        pMap = new HashMap<>();
        vis = new HashSet<>();
        dK = new ArrayList<>();
        t = target;

        assign(root);
        dfs(t, k);

        return dK;    
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || !vis.add(node)) return;

        if (k == 0) {
            dK.add(node.val);
            return;
        }

        dfs(pMap.get(node), k - 1);
        dfs(node.left, k - 1);
        dfs(node.right, k - 1);
    }

    private void assign(TreeNode node) {
        if (node == null) return;

        pMap.put(node.left, node);
        pMap.put(node.right, node);

        assign(node.left);
        assign(node.right);
    }
}