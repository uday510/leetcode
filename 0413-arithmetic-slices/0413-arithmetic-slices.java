class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int st = 0; st < n-2; ++st) {
            int diff = nums[st+1] - nums[st];
            for (int end = st+2; end < n; ++end) {
                int i;
                for (i = st+1; i <= end; ++i) {
                    if (nums[i] - nums[i-1] != diff) break;
                }
                if (i > end) cnt++;
            }
        }
        return cnt;
    }
}