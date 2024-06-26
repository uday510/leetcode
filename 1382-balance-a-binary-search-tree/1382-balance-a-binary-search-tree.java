class Solution {
    java.util.List<TreeNode> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currNode = root;
        
         while (true)  {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if (stack.isEmpty()) break;
            currNode = stack.pop();
            nodes.add(currNode);
            currNode = currNode.right;
        }
        
        // inorder(root);
        
        return balanceBST(0, nodes.size() - 1);
    }
    public TreeNode balanceBST(int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return null;

        int midIdx = (startIdx + endIdx) >>> 1;

        TreeNode currRoot = nodes.get(midIdx);

        currRoot.left = balanceBST(startIdx, midIdx - 1);
        currRoot.right = balanceBST(midIdx + 1, endIdx);

        return currRoot;
    }
    public void inorder(TreeNode node) {
        if (node == null)
            return;
        
        inorder(node.left);
        nodes.add(node);
        inorder(node.right);
    }
}