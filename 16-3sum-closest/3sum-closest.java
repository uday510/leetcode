class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        
        for (int i = 0; i < n-2; ++i) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
               int currSum = nums[i] + nums[j] + nums[k];
               int currDiff = Math.abs(target - currSum);

               if (currDiff < diff) {
                   diff = currDiff;
                   res = currSum;
               }

               if (currSum < target) {
                   j++; 
               } else {
                   k--;
               }
            } 
        }
        return res;
    }
}
