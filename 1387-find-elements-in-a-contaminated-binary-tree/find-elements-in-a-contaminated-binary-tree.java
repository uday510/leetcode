class FindElements {
    TreeNode root;
    Set<Integer> set;
    public FindElements(TreeNode root) {
        this.root = root;
        this.set = new HashSet<>();

        if (root == null) return;
        root.val = 0;
        dfs(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        set.add(node.val);
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
        }

        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
        }

        dfs(node.left);
        dfs(node.right);
    }
}
