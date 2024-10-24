class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        var map = new HashMap<Integer, int[]>();
        var queue = new LinkedList<TreeNode>();
        int currLevel = 1;

        map.put(root.val, new int[]{-1, 0});
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (; size > 0; --size) {
                TreeNode currNode = queue.poll();

                if (currNode == null) {
                    continue;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                    map.put(currNode.left.val, new int[]{currNode.val, currLevel});
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                    map.put(currNode.right.val, new int[]{currNode.val, currLevel});
                }
            }
            if (map.containsKey(x) && map.containsKey(y)) {
                return ans(map, x, y);
            }
            ++currLevel;
         }
        return ans(map, x, y);
    }
    private boolean ans(Map<Integer, int[]> map, int x, int y) {
        return (
            map.get(x)[0] != map.get(y)[0] &&
            map.get(x)[1] == map.get(y)[1]
         );
    }
}