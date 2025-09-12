class Solution {
    public int trap(int[] h) {
        int n = h.length, l = 0, r = h.length - 1, trapped = 0, lMax = 0, rMax = 0;

        while (l < r) {
            if (h[l] < h[r]) {
                lMax = Math.max(lMax, h[l]);
                trapped += lMax - h[l++];
            } else {
                rMax = Math.max(rMax, h[r]);
                trapped += rMax - h[r--];
            }
        }

        return trapped;
    }
}