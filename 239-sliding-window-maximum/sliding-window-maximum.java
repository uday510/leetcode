class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peekFirst() == i - k) {
                queue.pollFirst();
            }

            while (
                !queue.isEmpty() && 
                arr[queue.peekLast()] <= arr[i]) {
                    queue.pollLast();
            }

            queue.offerLast(i);

            if (i - k + 1 >= 0) {
                res[i - k + 1] = arr[queue.peekFirst()];
            }
        }

        return res;
    }
}