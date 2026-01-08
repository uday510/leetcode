class Solution {

    Map<Integer, Integer> map;
    int i;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        i = 0;
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, preorder.length - 1);
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) return null;

        TreeNode cur = new TreeNode(preorder[i++]);

        cur.left = dfs(l, map.get(cur.val) - 1);
        cur.right = dfs(map.get(cur.val) + 1, r);

        return cur;
    }
}