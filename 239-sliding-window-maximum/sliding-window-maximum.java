class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;

        for (int idx = 0; idx < len; ++idx) {
            int num = nums[idx];
            if (!queue.isEmpty() && queue.peekFirst() == idx - k) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < num) {
                queue.pollLast();
            }

            queue.offerLast(idx);

            if (idx >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }

        return res;
    }
}

