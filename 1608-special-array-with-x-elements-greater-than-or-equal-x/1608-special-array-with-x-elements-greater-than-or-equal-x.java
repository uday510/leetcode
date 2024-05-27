import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length; ++i) {
            if (nums.length - bisectLeft(i, nums) == i) 
                return i;
        }
        return -1;
    }

    public int bisectLeft(int target, int[] nums) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else 
                right = mid;
        }
        return left;
    }
}