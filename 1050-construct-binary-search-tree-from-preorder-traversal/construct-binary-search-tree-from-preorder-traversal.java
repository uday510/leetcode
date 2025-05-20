class Solution {
    Map<Integer, Integer> map;
    int[] inorder;
    int[] preorder;
    int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        map = new HashMap<>();
        inorder = new int[preorder.length];
        idx = 0;
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; ++i) {
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1);
    }
    private TreeNode dfs(int i, int j) {
        if (i > j) return null;

        TreeNode root = new TreeNode(preorder[idx++]);

        root.left = dfs(i, map.get(root.val) - 1);
        root.right = dfs(map.get(root.val) + 1, j);

        return root;
    }
}

// 1 5 7 8 10 12