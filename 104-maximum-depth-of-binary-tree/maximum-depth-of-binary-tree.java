class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
            
        int maxDepth = 0;
        var queue = new LinkedList<TreeNode>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            ++maxDepth;
        }
        return maxDepth;
    }
}