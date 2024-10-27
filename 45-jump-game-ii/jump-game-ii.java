class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int maxJump = 0;
        int currJump = 0;

        for (int i = 0; i < nums.length-1; ++i) {
            maxJump = Math.max(i + nums[i], maxJump);

            if (currJump == i) {
                ++jumps;
                currJump = maxJump;
            }
        }
        return jumps;
    }
}