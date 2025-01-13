class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = bs(nums, target);

        if (leftIdx >= nums.length || nums[leftIdx] != target) {
            return new int[]{-1, -1};
        }

        int rightIdx = bs(nums, target + 1) - 1;

        return new int[] {leftIdx, rightIdx};
    }

    private int bs(int[] nums, int target) {
        int leftIdx = 0;
        int rightIdx = nums.length;

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