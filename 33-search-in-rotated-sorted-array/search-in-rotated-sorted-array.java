class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length;
        
        while (i < j) {
            
            int mid = (i + j) >> 1;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[i] <= nums[mid]) {
                if (nums[i] > target || target > nums[mid]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[j - 1]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
        }
        
        return -1;
    }
}