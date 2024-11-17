class Solution {
    public int searchInsert(int[] nums, int target) {
        return bisectLeft(0, nums.length, target, nums);
    }
    private int bisectLeft(int leftIdx, int rightIdx, int target, int[] nums) {

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >> 1;

            if (nums[midIdx] < target) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx;
            }
        }

        return leftIdx;
    }
}