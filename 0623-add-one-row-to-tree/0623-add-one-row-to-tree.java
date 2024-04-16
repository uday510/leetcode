class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return createNewRoot(val, root);
        }
        
        insertNewRoot(root, val, depth - 1);
        return root;
    }
    
    private TreeNode createNewRoot(int value, TreeNode existingRoot) {
        TreeNode newRoot = new TreeNode(value);
        newRoot.left = existingRoot;
        return newRoot;
    }
    
    private void insertNewRoot(TreeNode currentNode, int value, int targetDepth) {
        if (currentNode == null) {
            return;
        }
        
        if (targetDepth == 1) {
            addNewChildren(currentNode, value);
            return;
        }
        
        insertNewRoot(currentNode.left, value, targetDepth - 1);
        insertNewRoot(currentNode.right, value, targetDepth - 1);
    }
    
    private void addNewChildren(TreeNode node, int value) {
        node.left = new TreeNode(value, node.left, null);
        node.right = new TreeNode(value, null, node.right);
    }
}