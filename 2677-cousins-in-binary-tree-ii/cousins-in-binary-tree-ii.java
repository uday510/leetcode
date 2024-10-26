class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        var list = new ArrayList<Integer>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currSum = 0;
            while (size-- > 0) {
                TreeNode currNode = queue.poll();
                currSum += currNode.val;

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            list.add(currSum);
        }
        
        int currLevel = 1;
        queue.offer(root);
        root.val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode currNode = queue.poll();

                int sum = (currNode.left != null ? currNode.left.val : 0) + 
                          (currNode.right != null ? currNode.right.val : 0);

                if (currNode.left != null) {
                    currNode.left.val = list.get(currLevel) - sum;
                    queue.offer(currNode.left);
                }
                    
                if (currNode.right != null) {
                    currNode.right.val = list.get(currLevel) - sum;
                    queue.offer(currNode.right);
                }
            }
            ++currLevel;
        }
        return root;
    }
}