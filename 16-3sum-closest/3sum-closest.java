class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = (int) 1e9, N = nums.length;
        int closest = (int) 1e9;

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                for (int k = j + 1; k < N; ++k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < minDiff) {
                        closest = sum;
                        minDiff = Math.abs(sum - target);
                    } 
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