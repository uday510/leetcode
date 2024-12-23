class Solution {
    private Queue<TreeNode> queue;
    private List<Integer> list1;
    private List<Integer> list2;
    private int result;
    public int minimumOperations(TreeNode root) {
        intialize();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();

            for (int idx = 0; idx < size; ++idx) {
                TreeNode currNode = queue.poll();

                if (currNode == null) {
                    continue;
                }

                list1.add(currNode.val);
                list2.add(currNode.val);

                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }

            calculateMinSwapsForCurrLevel();
        }

        return result;
    }

    private void calculateMinSwapsForCurrLevel() {
        Collections.sort(list2);
        HashMap<Integer, Integer> map = new HashMap<>();
        int current = 0;
        int len = list1.size();
        
        for (int idx = 0; idx < len; ++idx) {
            map.put(list1.get(idx), idx);
        }

        for (int idx = 0; idx < len; ++idx) {
            int x = list1.get(idx);
            int y = list2.get(idx);

            if (x != y) {
                current += 1;

                int pos = map.get(y);
                map.put(x, pos);
                list1.set(pos, x);
            }
        }

        result += current;
    }

    private void intialize() {
        queue = new LinkedList<>();
        result = 0;
    }
}