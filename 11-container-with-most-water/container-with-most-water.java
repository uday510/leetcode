class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int water = 0;

        while (i < j) {
            int curr = Math.min(height[i], height[j]) * (j - i);
            water = Math.max(curr, water);

            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return water;
    }
}