class Solution {
    int[] nums;
    public void wiggleSort(int[] nums) {
        this.nums = nums;

        for (int i = 0; i < nums.length - 1; ++i) {
            if (i % 2 == 0 && nums[i] > nums[i+1] || i % 2 == 1 && nums[i] < nums[i + 1]) {
                    swap(i, i + 1);
            }
        }
    }
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}