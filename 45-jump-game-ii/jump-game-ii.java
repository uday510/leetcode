class Solution {
    public int jump(int[] nums) {
        
        int steps = 0, lastPos = 0, mxFar = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            mxFar = Math.max(mxFar, i + nums[i]);

            if (lastPos == i) {
                lastPos = mxFar;
                steps++;
            }
        }

        return steps;
    }
}