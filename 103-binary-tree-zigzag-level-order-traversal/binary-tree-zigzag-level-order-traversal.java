class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean leftToRight = true;

        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> curLevel = new LinkedList<>();
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();

                if (leftToRight) curLevel.addLast(cur.val);
                else curLevel.addFirst(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            res.add(curLevel);
            leftToRight = !leftToRight;
        }

        return res;
    }
}