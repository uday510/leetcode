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

    Map<Integer, List<Integer>> map;

    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        dfs(root, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        int t = -1;

        Set<Integer> vis = new HashSet<>();
        vis.add(start);

        while (!queue.isEmpty()) {
            int n = queue.size();
            t++;

            for (int i = 0; i < n; i++) {
                int u = queue.poll();
                for (int v : map.get(u)) {
                    if (!vis.add(v)) continue;
                    queue.offer(v);
                }
            }
        }

        return t;
    }

    private void dfs(TreeNode node, int p) {
        if (node == null) return;

       List<Integer> l =  map.computeIfAbsent(node.val, _ -> new ArrayList<>());

        if (p != -1) l.add(p);

        if (node.left != null) l.add(node.left.val);
        if (node.right != null) l.add(node.right.val);

        dfs(node.left, node.val);
        dfs(node.right, node.val);
    }
}