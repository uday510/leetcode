class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];

            boolean isLeftChild = desc[2] == 1;

            TreeNode parentNode = nodeMap.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));

            TreeNode childNode = nodeMap.computeIfAbsent(childVal, k -> new TreeNode(childVal));

            if (isLeftChild) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(childVal);
        }

        for (var key : nodeMap.keySet()) {
            if (!children.contains(key)) {
                return nodeMap.get(key);
            }
        }

        return null;
    }
}