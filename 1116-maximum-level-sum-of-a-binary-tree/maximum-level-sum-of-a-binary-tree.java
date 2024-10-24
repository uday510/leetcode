class Solution {
    public int maxLevelSum(TreeNode root) {
        var heap = new PriorityQueue<int[]> ((p1, p2) -> Integer.compare(p2[1], p1[1]));
        var queue = new LinkedList<TreeNode>();
        int currLevel = 1;

        queue.offer(root);
        heap.offer(new int[]{currLevel, root.val});

        while (!queue.isEmpty()) {
            int size = queue.size();
            int currSum = 0;

            for (; size > 0; --size) {
                TreeNode currNode = queue.poll();
                if (currNode == null) {
                    continue;
                }
                currSum += currNode.val;

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            System.out.println(currLevel + " " + currSum);

            heap.offer(new int[]{currLevel, currSum});
            ++currLevel;
        }

        return heap.poll()[0];
    }
}