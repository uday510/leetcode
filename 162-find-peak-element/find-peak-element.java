class Solution {
    public int findPeakElement(int[] nums) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >>> 1;

            if (nums[midIdx] < nums[midIdx + 1]) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx;
            }
        }
        return rightIdx;
    }
}