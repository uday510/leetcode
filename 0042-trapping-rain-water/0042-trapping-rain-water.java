class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int waterTrapped = 0;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
                right--;
            }
        }
        return waterTrapped;
    }
}