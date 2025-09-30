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

    enum State {
        COVERED,
        NEED_CAMERA,
        HAS_CAMERA
    }

    int cameras;
    public int minCameraCover(TreeNode root) {
        cameras = 0;
        State state = dfs(root);
        return state == State.NEED_CAMERA ? cameras + 1 : cameras;
    }

    private State dfs(TreeNode node) {
        if (node == null) return State.COVERED;

        State l = dfs(node.left);
        State r = dfs(node.right);

        if (l == State.NEED_CAMERA || r == State.NEED_CAMERA) {
            cameras++;
            return State.HAS_CAMERA;
        }

        if (l == State.HAS_CAMERA || r == State.HAS_CAMERA) {
            return State.COVERED;
        }

        return State.NEED_CAMERA;
    }
}