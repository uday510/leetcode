class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left + n / 2 < n && nums[left + n / 2] == target;
    }
}