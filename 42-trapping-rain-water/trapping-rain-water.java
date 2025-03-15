class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int trapped = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                trapped += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                trapped += rightMax - height[right--];
            }
        }
        return trapped;
    }
}