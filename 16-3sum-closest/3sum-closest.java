class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = (int) 1e9, n = nums.length;
        int closest = (int) 1e9;

        for (int idx = 0; idx < n - 2; ++idx) {
            int left = idx + 1, right = n - 1;

            while (left < right) {
                int curr = nums[idx] + nums[left] + nums[right];

                if (curr - target == 0) return curr;
                else if (curr - target < 0) left++;
                else right--;

                int diff = Math.abs(curr - target); 
                if (diff < minDiff) {
                    closest = curr;
                    minDiff = diff;
                }
            }
        }
        
        return closest;
    }
}

/**

-4 -1 1 2

4 


ans 6

1 1 4 5 6 7 

t = 1


-4 -1 1 2
t = 1
closest = -1, minDiff = 2

curr = -1 
diff = 2

-------------------
1 1 4 5 6 7 

t = 4

minDiff = 2 
closest = 6

curr = 8
diff = 4

*/