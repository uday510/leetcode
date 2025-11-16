class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int maxArea = 0;

        while (l < r) {
            int curArea = Math.min(h[l], h[r]) * (r - l);

            maxArea = Math.max(maxArea, curArea);

            if (h[l] < h[r]) l++;
            else r--;
        }

        return maxArea;
    }
}