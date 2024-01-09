class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1, new ArrayList<Integer>()).
        equals(dfs(root2, new ArrayList<Integer>()));
    }

    public List<Integer> dfs(TreeNode r, ArrayList<Integer> list) {
        if (r == null) return list;
  
        dfs(r.right, list);
        dfs(r.left, list);

        checkLeaf(r, list);
        return list;
    }
    public void checkLeaf(TreeNode r, ArrayList<Integer> list) {
        if (r.left == null && r.right == null)
            list.add(r.val);
    }
}
