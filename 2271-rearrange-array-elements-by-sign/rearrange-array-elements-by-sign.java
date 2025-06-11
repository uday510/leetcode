class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int index = 0;
        Queue<Integer> pos = new ArrayDeque<>();
        Queue<Integer> neg = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (num > -1) pos.offer(num);
            else neg.offer(num);

            if (!pos.isEmpty() && !neg.isEmpty()) {
                nums[index++] = pos.poll();
                nums[index++] = neg.poll();
            }
        }

        return nums;
    }
}