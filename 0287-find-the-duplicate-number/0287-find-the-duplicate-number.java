class Solution {
    public int findDuplicate(int[] nums) {
        
        for (int num : nums) {
            int val = Math.abs(num);
            
            if (nums[val] < 0) {
                return val;
            }
            nums[val] *= -1;
        }
        return -1;
    }
}


/*


*/
