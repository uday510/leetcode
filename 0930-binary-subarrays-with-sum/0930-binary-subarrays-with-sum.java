class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int subarrays = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; ++i) {
            int currSum = 0;
            for (int j = i; j < n; ++j) {
                currSum += nums[j];
                if (currSum == goal) {
                    subarrays++;
                }
            }
        }
        return subarrays;
    }
}