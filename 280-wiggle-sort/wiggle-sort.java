class Solution {
    int[] nums;
    public void wiggleSort(int[] nums) {
        this.nums = nums;

        for (int i = 0; i < nums.length - 1; i += 1) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }
    }
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}