class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n - 2;

        while (pivot > -1 && nums[pivot] >= nums[pivot + 1]) pivot--;

        if (pivot < 0) {
            reverse(0, n - 1, nums);
            return;
        }

        int j = n - 1;
        while (pivot < j && nums[j] <= nums[pivot]) j--;

        swap(pivot, j, nums);

        reverse(pivot + 1, n - 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i++, j--, nums);
        }
    }
}