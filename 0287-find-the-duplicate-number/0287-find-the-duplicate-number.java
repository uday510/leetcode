class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1; // Adjusting the right boundary
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
