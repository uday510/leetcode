class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] pf = new int[len];

        int curr = 0;
        for (int i = 0; i < len; ++i) {
            pf[i] = curr;
            curr += nums[i];
        }
        
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            int sum = 0;
            for (int j = i; j < len; ++j) {
                sum += nums[j];
                if (sum == k) cnt++;
            }
        }

        return cnt;
    }
}