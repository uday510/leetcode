class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        int idx = 1;

        while (idx < nums.length) {
            if (nums[idx] == majority) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majority = nums[idx];
                count = 1;
            }

            idx++;
        }

        return majority;
    }
}