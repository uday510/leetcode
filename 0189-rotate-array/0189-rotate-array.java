class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k %= n;
        reverse(0, n-1, nums);
        reverse(0, k-1, nums);
        reverse(k, n-1, nums);
    }
    public void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i,j,nums);
            ++i;
            --j;
        }
    }
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}