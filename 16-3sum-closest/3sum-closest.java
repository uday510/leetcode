class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);

        int minDif, curDif, curSum;
        int n = nums.length;

        minDif = curDif = (int) 1e9;
        int closest = minDif;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;

            while (j < k) {
                curSum = nums[i] + nums[j] + nums[k];

                if (curSum - target == 0) return curSum;
                else if (curSum - target < 0) j++;
                else k--;

                curDif = Math.abs(curSum - target);
                if (curDif < minDif) {
                    closest = curSum;
                    minDif = curDif;
                }

            }
        }

        return closest;
    }
}