class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftIdx = 0;
        int rightIdx = n-1;
        int trapped = 0;
        int leftMax = height[0];
        int rightMax = height[n-1];

        while (leftIdx < rightIdx) {
            if (height[leftIdx] < height[rightIdx]) {
                leftMax = Math.max(leftMax, height[leftIdx]);
                trapped += leftMax - height[leftIdx++];
            } else {
                rightMax = Math.max(rightMax, height[rightIdx]);
                trapped += rightMax - height[rightIdx--];
            }
        }
        return trapped;
    }
}