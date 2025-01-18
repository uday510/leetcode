class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    private void reverse(int leftIdx, int rightIdx, int[] nums) {

        while (leftIdx < rightIdx) {
            swap(leftIdx++, rightIdx--, nums);
        }
    }

    private void swap(int idx1, int idx2, int[] nums) {
        int temp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = temp;
    }
    
}