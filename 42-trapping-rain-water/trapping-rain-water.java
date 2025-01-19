class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int leftIdx = 0;
        int rightIdx = length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trapped = 0;

        while (leftIdx < rightIdx) {
            
            if (height[leftIdx] <= height[rightIdx]) {
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