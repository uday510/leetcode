class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int trapped = 0;
        int lMax = 0, rMax = 0;

        while (l <= r) {
            if (height[l] <= height[r]) {
                lMax = Math.max(lMax, height[l]);
                trapped += (lMax - height[l]);
                l++;
            } else {
                rMax = Math.max(rMax, height[r]);
                trapped += (rMax - height[r]);
                r--;
            }
        }

        return trapped;
    }
}