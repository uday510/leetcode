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

    Map<Integer, List<TreeNode>> dp;

    public List<TreeNode> allPossibleFBT(int n) {
        dp = new HashMap<>();

        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if (n < 1) return new ArrayList<TreeNode>();

        if (n == 1) return Arrays.asList(new TreeNode());

        if (dp.containsKey(n)) return dp.get(n);

        List<TreeNode> list = new ArrayList<>();

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = dfs(i);
            List<TreeNode> right = dfs(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    list.add(root);
                }
            }
        }

        dp.put(n, list);

        return list;
    }
}