class Solution {
    public int countPartitions(int[] nums) {
        int rSum = Arrays.stream(nums).sum();
        int lSum = 0, res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            lSum += nums[i];
            rSum -= nums[i];

            res += (Math.abs(lSum - rSum) & 1) == 0 ? 1 : 0;
        }

        return res;
    }
}