class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            TreeNode rightNode = null;

            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();

                rightNode = cur;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            if (rightNode != null) res.add(rightNode.val);
        }
        
        return res;
    }
}