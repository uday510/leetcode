class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        int tmp, curLevel = 1, mx = -(int) 1e9, res = 1, sz;

        TreeNode curNode;

        while (!queue.isEmpty()) {
            sz = queue.size();
            tmp = 0;

            for (int i = 0; i < sz; ++i) {
                curNode = queue.poll();
                tmp += curNode.val;

                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }

            if (tmp > mx) {
                mx = tmp;
                res = curLevel;
            }

            ++curLevel;
        }

        return res;
    }

}