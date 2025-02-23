class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;

            for (int idx = 0; idx < size; ++idx) {
                TreeNode currNode = queue.poll();

                if (currNode == null) continue;

                node = currNode;

                queue.offer(node.left);
                queue.offer(node.right);
            }

            if (node != null) result.add(node.val);
        }

        return result;
    }
}