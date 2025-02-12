class Solution {
    public int search(int[] nums, int target) {
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

        return leftIdx < nums.length && nums[leftIdx] == target ? leftIdx : -1;
    }
}