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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean leftToRight = true;

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = getCurLevel(queue, leftToRight);

            levels.add(curLevel);

            leftToRight = !leftToRight;
        }

        return levels;
    }

    private List<Integer> getCurLevel(Queue<TreeNode> queue, boolean leftToRight) {
        List<Integer> level = new LinkedList<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();

            if (leftToRight) level.addLast(cur.val);
            else level.addFirst(cur.val);

            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }

        return level;
    }
}

/**

[3]
[9,20]
[15,7]
 */