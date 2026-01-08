class Solution {
    public int maxArea(int[] H) {
        
        int maxArea = 0, curArea;
        int l = 0, r = H.length - 1;

        while (l < r) {
            curArea = Math.min(H[l], H[r]) * (r - l);

            maxArea = Math.max(curArea, maxArea);

            if (H[l] <= H[r]) l++;
            else r--;
        }

        return maxArea;
        
    }
}