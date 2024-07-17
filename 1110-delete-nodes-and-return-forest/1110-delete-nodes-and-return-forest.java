class Solution {
    Set<Integer> set;
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        ans = new ArrayList<>();
        for (int val : to_delete)
            set.add(val);

        TreeNode node = dfs(root);
        if (node != null) 
            ans.add(node);
        return ans;
    }
    
    public TreeNode dfs(TreeNode node) {
        if (node == null)
            return null;
        

        node.left = dfs(node.left);
        node.right = dfs(node.right);
        
        if (set.contains(node.val)) {
            if (node.left != null)
                ans.add(node.left);
            if (node.right != null)
                ans.add(node.right);
            return null;
        }
        
        return node;
    }
}