class Solution {
    public int maxSubArray(int[] nums) {
        int currSubArraySum = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        
        for (int num : nums) {
            currSubArraySum += num;
            
            if (currSubArraySum > maxSubArraySum) {
                maxSubArraySum = currSubArraySum;
            }
            
            if (currSubArraySum < 0) {
                currSubArraySum = 0;
            }
        }
        return maxSubArraySum;
     }
}