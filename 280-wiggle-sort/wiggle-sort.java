class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(i, i + 1, nums);
        }
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}