class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode currNode = root;
        TreeNode tempNode;

        while (currNode != null) {
            if (currNode.left == null) {
                res.add(currNode.val);
                currNode = currNode.right;
            } else {
                tempNode = currNode.left;
                while (tempNode.right != null && tempNode.right != currNode) {
                        tempNode = tempNode.right;
                }
                if (tempNode.right == null) {
                    tempNode.right = currNode;
                    currNode = currNode.left;
                } else {
                    tempNode.right = null;
                    res.add(currNode.val);
                    currNode = currNode.right;
                }
            }
        }
        return res;
    } 
}