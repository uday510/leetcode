class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
                continue;
            }

            TreeNode rightMost = curr.left;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = curr.right;
            curr.right = curr.left;
            curr.left = null;

            curr = curr.right;
        }
    }
}