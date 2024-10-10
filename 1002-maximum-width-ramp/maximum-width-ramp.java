class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;

        for (int i = 0; i < len; ++i) {
            if (deque.isEmpty() || nums[deque.peekLast()] > nums[i]) {
                deque.offerLast(i);
            }
        }

        int maxWidth = 0;

        for (int j = len - 1; j >= 0; --j) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - deque.pollLast());
            }
        }

        return maxWidth;
    }
}
