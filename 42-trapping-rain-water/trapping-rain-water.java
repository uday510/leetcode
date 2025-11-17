class Solution {
    public int trap(int[] h) {
        int l = 0, r = h.length - 1;
        int lMax = 0, rMax = 0;
        int trapped = 0;

        while (l <= r) {
            if (h[l] <= h[r]) {
                lMax = Math.max(h[l], lMax);
                trapped += lMax - h[l++];
            } else {
                rMax = Math.max(h[r], rMax);
                trapped += rMax - h[r--];
            }
        }

        return trapped;   
    }
}