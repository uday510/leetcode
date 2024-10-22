/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        bfs(root, list);
        System.out.println(list);
        Collections.sort(list);
        return k <= list.size() ? list.get(list.size() - k) : -1;
    } private void bfs(TreeNode root, List<Long> list) {
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
           long currSum = 0L;
           int len = queue.size();

           for (; len > 0; --len) {
                TreeNode currNode = queue.poll();
                currSum += (long) currNode.val;

                for (var node : new TreeNode[] {currNode.left, currNode.right}) {
                    if (node != null) {
                        queue.offer(node);
                    }
                }
           }
            list.add(currSum);
        }
    }
}