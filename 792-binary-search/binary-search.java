class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target);
    }

    private int bs(int[] nums, int target) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >> 1;

            if (nums[midIdx] < target) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx;
            }
        }

        return nums[leftIdx] != target ? -1 : leftIdx;
    }
}