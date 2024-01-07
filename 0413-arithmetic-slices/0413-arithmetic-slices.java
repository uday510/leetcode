class Solution {
    int total;
    public int numberOfArithmeticSlices(int[] nums) {
        total = 0;
        dfs(nums, nums.length-1);
        return total;
    }
    public int dfs(int[] nums, int i) {
        if (i < 2) return 0;
        
        int curr = 0;
        if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
            curr = 1 + dfs(nums, i-1);
            total += curr;
        } else {
            dfs(nums, i-1);
        }
        return curr;
    }
}