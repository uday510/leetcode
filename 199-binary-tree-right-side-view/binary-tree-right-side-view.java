class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        var list = new ArrayList<Integer>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer val = null;

            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                val = node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (val != null) {
                list.add(val);
            }
        }
        return list;
    }
}