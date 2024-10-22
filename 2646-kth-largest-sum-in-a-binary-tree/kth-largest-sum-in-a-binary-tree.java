class Solution {
    List<Long> list;
    Queue<TreeNode> queue;
    public long kthLargestLevelSum(TreeNode root, int k) {
        bfs(root);
        return ans(k);
    } private void bfs(TreeNode root) {
        queue = new LinkedList<TreeNode>();
        list = new ArrayList<Long>(); 
        queue.offer(root);

        while (!queue.isEmpty()) {
           long currSum = 0L;
           int len = queue.size();

           for (; len > 0; --len) {
                TreeNode currNode = queue.poll();
                currSum += (long) currNode.val;
                addNodes(currNode);
           }
            list.add(currSum);
        }
    }
    private void addNodes(TreeNode currNode) {
        for (var node : new TreeNode[] {currNode.left, currNode.right}) {
            if (node != null) {
                queue.offer(node);
            }
        }
    }
    private long ans(int k) {
        Collections.sort(list);
        return k > list.size() ? -1 : list.get(list.size() - k);
    }
}