class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        var levels = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            var level = getLevel(queue);

            levels.add(level);
        }
        return levels;
    }
    private List<Integer> getLevel(LinkedList<TreeNode> queue) {
        int size = queue.size();
        var level = new ArrayList<Integer>();

        for (int i = 0; i < size; ++i) {
            TreeNode node = queue.poll();

            if (node == null) {
                continue;
            }

            level.add(node.val);

            if(node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return level;
    }
}