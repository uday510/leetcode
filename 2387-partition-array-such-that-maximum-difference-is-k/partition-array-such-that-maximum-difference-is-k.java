class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 1;
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; ++i) {
            int curr = nums[i];
            min = Math.min(min, curr);
            max = Math.max(max, curr);
            if (max - min > k) {
                cnt++;
                max = min = curr;
            }
        }

        return cnt;
    }
}