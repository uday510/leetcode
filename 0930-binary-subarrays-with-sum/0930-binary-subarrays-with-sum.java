class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int len = nums.length;
        
       
        for (int i = 0; i < len; ++i) {
             int sum = 0;
            for (int j = i; j < len; ++j) {
                sum += nums[j];
                
                if (sum == goal) count++;
                if (sum > goal) break;
            }
        }
        
        return count;
    }
}