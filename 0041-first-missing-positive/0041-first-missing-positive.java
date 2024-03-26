class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            
            while (nums[i] < n && nums[i] > 0 && nums[i] != i + 1) {
                int val = nums[i];
                
                if (val == nums[val - 1]) break;
                
                swap(i, val - 1, nums);
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
    public void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
}

