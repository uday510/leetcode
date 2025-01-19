class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int trapped = 0;

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        for (int idx = 1; idx < len; ++idx) {
            leftMax[idx] = Math.max(height[idx], leftMax[idx - 1]);
        }

        rightMax[len - 1] = height[len - 1];
        for (int idx = len - 2; idx > -1; --idx) {
            rightMax[idx] = Math.max(height[idx], rightMax[idx + 1]);
        }

        for (int idx = 0; idx < len; ++idx) {
            trapped += Math.min(leftMax[idx], rightMax[idx]) - height[idx];
        }

        return trapped;
    }
}