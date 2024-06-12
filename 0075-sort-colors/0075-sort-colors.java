class Solution {
    public void sortColors(int[] nums) {
        int redIndex = 0, whiteIndex = 0, blueIndex = nums.length - 1;

        while (whiteIndex <= blueIndex) {
            if (nums[whiteIndex] == 0) {
                swap(nums, redIndex, whiteIndex);
                redIndex++;
                whiteIndex++;
            } else if (nums[whiteIndex] == 2) {
                swap(nums, whiteIndex, blueIndex);
                blueIndex--;
            } else {
                whiteIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}