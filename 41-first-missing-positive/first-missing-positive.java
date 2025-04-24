class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int idx = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[idx]) {
                swap(idx, i, nums);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        
        return n + 1;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}