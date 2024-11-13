class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        var levels = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        boolean leftToRight = true;

        queue.offer(root);
        
        while (!queue.isEmpty()) {
            var level = getLevel(leftToRight, queue);

            levels.add(level);

            leftToRight = !leftToRight;
        }

        return levels;
    }
    private List<Integer> getLevel(boolean leftToRight, LinkedList<TreeNode> queue) {
        var level = new ArrayList<Integer>();
        int size = queue.size();

        for (int i = 0; i < size; ++i) {
            TreeNode node = queue.poll();

            if (node == null) {
                continue;
            }

            level.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        if (!leftToRight) {
            Collections.reverse(level);
        }

        return level;
    }
}