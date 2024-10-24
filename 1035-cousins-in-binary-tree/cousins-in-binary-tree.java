class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        var queue = new LinkedList<TreeNode>();
        var parentMap = new HashMap<Integer, Integer>();  // Maps node to parent value
        var levelMap = new HashMap<Integer, Integer>();   // Maps node to its level
        
        queue.offer(root);
        parentMap.put(root.val, -1);  // Root has no parent, use -1
        levelMap.put(root.val, 0);    // Root is at level 0
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                    parentMap.put(node.left.val, node.val);   // Track parent
                    levelMap.put(node.left.val, levelMap.get(node.val) + 1);  // Track level
                    if (parentMap.containsKey(x) && parentMap.containsKey(y)) {
                        return ans(parentMap, levelMap, x, y);
                    }
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                    parentMap.put(node.right.val, node.val);  // Track parent
                    levelMap.put(node.right.val, levelMap.get(node.val) + 1); // Track level
                    if (parentMap.containsKey(x) && parentMap.containsKey(y)) {
                        return ans(parentMap, levelMap, x, y);
                    }
                }
            }
        }
        return ans(parentMap, levelMap, x, y);  // Final check outside loop
    }
    
    private boolean ans(Map<Integer, Integer> parentMap, Map<Integer, Integer> levelMap, int x, int y) {
        // Check if parents are different and levels are the same
        return parentMap.get(x) != parentMap.get(y) && levelMap.get(x) == levelMap.get(y);
    }
}
