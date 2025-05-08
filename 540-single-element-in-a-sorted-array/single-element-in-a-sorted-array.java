class Solution {
    public int singleNonDuplicate(int[] nums) {
       int left = 0, right = nums.length - 1;
       
       while (left < right) {
            int mid = (left + right) >> 1;

            if (mid % 2 == 0) mid--;

            if (nums[mid] == nums[mid + 1]) right = mid - 1;
            else left = mid + 1;
       }

       return nums[left];
    }
}

/**

0 1 2 3 4 5 6 7 8
1 1 2 2 3 3 4 8 8

left = 0
right = 9


 */