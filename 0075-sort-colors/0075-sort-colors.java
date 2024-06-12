class Solution {
    public void sortColors(int[] nums) {
        int idx0 = 0;
        int idx1 = 0;
        int idx2 = nums.length - 1;
        
        while (idx1 <= idx2) {
            if (nums[idx1] == 0) {
                swap(idx0, idx1, nums);
                idx0++;
                idx1++;
            } else if (nums[idx1] == 1) {
                // idx0++;
                idx1++;
            } else {
                swap(idx1, idx2, nums);
                idx2--;
            }
        }
    }
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}