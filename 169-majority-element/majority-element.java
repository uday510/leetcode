class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], cnt = 0;

        for (int num : nums) {
            if (num == major) cnt++;
            else cnt--;

            if (cnt == 0) {
                major = num;
                cnt = 1;
            }
        }

        return major;
    }
}