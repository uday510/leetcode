class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean leftToRight = true;

        queue.offer(root);
        while (!queue.isEmpty()) {

            Deque<Integer> curLevel = new ArrayDeque<>();
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();

                if (leftToRight) curLevel.offerLast(cur.val);
                else curLevel.offerFirst(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            res.add(new ArrayList<>(curLevel));
            leftToRight = !leftToRight;
        }

        return res;
    }
}