
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair p = lcaDeepestLeaves(root, 0);
        return p.node;
    }

    public Pair lcaDeepestLeaves(TreeNode root, int d) {
        if (root == null) return new Pair(null, d);

        Pair l = lcaDeepestLeaves(root.left, d+1);
        Pair r = lcaDeepestLeaves(root.right, d+1);

        if (l.d == r.d) {
            return new Pair(root, l.d);
        }
        return l.d > r.d ? l : r;
    }

    class Pair {
        TreeNode node;
        int d;

        public Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }
    
}