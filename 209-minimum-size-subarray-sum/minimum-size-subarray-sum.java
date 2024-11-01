class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) 
            return 0;

        int i = 0;
        int j = 0;
        int N = nums.length;
        int min = N;
        int curr = 0;

        while (j < N) {
            curr += nums[j];
            if (curr >= target) {
                min = Math.min(min, j-i+1);
                while (i < N && curr-nums[i] >= target) {
                curr -= nums[i++];
                min = Math.min(min, j-i+1);
                }
            }
            ++j;
        }
        return min;
    }
}