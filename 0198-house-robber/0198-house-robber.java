class Solution {
    public int rob(int[] nums) {
        int currHouse = 0;
        int prevHouse = 0;

        for (int i = 0; i < nums.length; ++i) {
            int currRobbed = Math.max(currHouse, prevHouse + nums[i]);

            prevHouse = currHouse;
            currHouse = currRobbed;
        }
        return Math.max(currHouse, prevHouse);
    }
}