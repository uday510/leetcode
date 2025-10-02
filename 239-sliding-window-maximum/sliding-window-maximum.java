class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peekFirst() == i - k) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }

        return res;
        
    }
}

/**

0  1   2   3  4  5  6  7        
1, 3, -1, -3, 5, 3, 6, 7


queue: 7

res: 3 3 5 5 6 7



 */