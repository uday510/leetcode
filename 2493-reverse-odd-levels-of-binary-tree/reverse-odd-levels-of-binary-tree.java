class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean oddLevel = false;
        queue.offer(root);

        while (!queue.isEmpty()) {
            
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();

            for (int idx = 0; idx < size; ++idx) {
                TreeNode currNode = queue.poll();

                if (currNode == null) {
                    continue;
                }

                if (oddLevel) {
                    list.add(currNode);
                }

                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }

            if (oddLevel) {
                swap(list);
            }

            oddLevel = !oddLevel;
        }

        return root;
    }
    
    private void swap(List<TreeNode> list) {

        int idx1 = 0;
        int idx2 = list.size() - 1;

        while (idx1 < idx2) {
            int tmp = list.get(idx2).val;
            list.get(idx2--).val = list.get(idx1).val;
            list.get(idx1++).val = tmp;
        }
    }
}