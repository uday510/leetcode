class Solution {
    public int minimumCost(int[] nums) {        
        int m1, m2;
        m1 = m2 = (int) 1e9;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < m1) {
                m2 = m1;
                m1 = nums[i];
            } else if (nums[i] < m2) {
                m2 = nums[i];
            }
        }
        
        return nums[0] + m1 + m2;
    }
}