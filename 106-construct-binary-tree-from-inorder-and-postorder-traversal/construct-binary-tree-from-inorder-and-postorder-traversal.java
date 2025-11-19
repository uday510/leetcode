class Solution {

    Map<Integer, Integer> map;
    int i;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        i = postorder.length - 1;
        this.postorder = postorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }    

        return dfs(0, postorder.length - 1);
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) return null;

        TreeNode cur = new TreeNode(postorder[i--]);

        cur.right = dfs(map.get(cur.val) + 1, r);
        cur.left = dfs(l, map.get(cur.val) - 1);

        return cur;
    }
}