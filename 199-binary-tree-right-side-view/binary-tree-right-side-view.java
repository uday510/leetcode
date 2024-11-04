class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        var q = new LinkedList<TreeNode>();
        var res = new ArrayList<Integer>();

        q.offer(root);
        res.add(root.val);
        while (!q.isEmpty()) {
            int n = q.size();

            var list = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) {
                TreeNode node = q.poll();

                if (node == null)
                    continue;
                if (node.left != null) {
                    list.add(node.left.val);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    q.offer(node.right);
                }
            }
            System.out.println(list);
            if (list.size() > 0)
                res.add(list.get(list.size()-1));
        }
        return res;
    }
}