class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n-2; ++i) {
            int diff = nums[i+1] - nums[i];
            for (int j = i+2; j < n; ++j) {
                if (nums[j] - nums[j-1] == diff) cnt++;
                else break;
            }
        }
        return cnt;
    }
}