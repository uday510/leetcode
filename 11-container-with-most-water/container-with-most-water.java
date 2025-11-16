class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int maxArea = 0;

        while (l < r) {
            int curArea;
            if (h[l] < h[r]) {
                curArea = (r - l) * h[l];
                maxArea = Math.max(maxArea, curArea);
                l++;
            } else {
                curArea = (r - l) * h[r];
                maxArea = Math.max(maxArea, curArea);
                r--;
            }
        }

        return maxArea;
    }
}