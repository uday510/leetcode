class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int index = 0; index < nums.length; ++index) {
            int currNum = nums[index];

            if (!queue.isEmpty() && currNum - queue.peekLast() != 1) {
                queue.clear();
            }

            queue.offer(currNum);

            if (index >= k - 1) {
                ans.add(queue.size() >= k ? queue.peekLast() : -1);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}