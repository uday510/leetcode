class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n+1)/2;
        
        int curr = 0;
        for (int i = 0; i < n; ++i)
            curr += nums[i];
        
        return total - curr;
    }
}