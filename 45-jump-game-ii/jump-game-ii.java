class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int curJump = 0, maxJump = 0, jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);

            if (curJump == i) {
                jumps++;
                curJump = maxJump;
            }

            if (curJump >= n - 1) return jumps;
        }

        return jumps;
    }
}