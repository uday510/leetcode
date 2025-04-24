class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i > -1 && nums[i] >= nums[i + 1]) i--;

        if (i < 0) {
            reverse(0, nums.length - 1, nums);
            return;
        }

        int j = nums.length - 1;

        while (j > -1 && nums[j] <= nums[i]) j--;


        swap(i, j, nums);

        reverse(i + 1, nums.length - 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    private void reverse(int i, int j, int[] nums) {
        while (i < j) swap(i++, j--, nums);
    }
}