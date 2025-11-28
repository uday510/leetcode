class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int curEnd = 0, farthest = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (curEnd == i) {
                jumps++;
                curEnd = farthest;
            }
        }

        return jumps;
    }
}